package com.cryptowallet.API.exchangerate;

import com.cryptowallet.models.exchangerateModels.*;
import com.cryptowallet.models.exchangerateModels.enumpack.Period;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Component
@EnableWebMvc
public class ExchangeRateAPIImpl implements ExchangeRateAPI{
    private final String TIME_ZONE = "Z";
    private final long H24 = 24L;
    private final String LOG_MSG = "Request failed!";
    private final String MSG_EXC = "Position start or limit dont correct!";
    private final String RANG_CHANGE = "Coins rang change, coin name is: ";
    private RestTemplate restTemplate;
    private BuilderURL builderURL;
    private List<CoinID> coinID;

    @Autowired
    public ExchangeRateAPIImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.builderURL = new BuilderURL();
        updateCoinIdList();
    }

    @Override
    public void updateCoinIdList() {
        ResponseEntity <List<CoinID>> response = restTemplate.exchange(builderURL.getCoinIdURL(), HttpMethod.GET,
                null, new ParameterizedTypeReference<List<CoinID>>(){});
        if(response.getStatusCode().is2xxSuccessful()) {
            this.coinID = response.getBody();
            coinID.removeIf(c ->(c.getRank() == 0));//лист содержит порядка 2000 неактивных валют, поэтому удаляю
        }else {
            log.warn(LOG_MSG);
        }
    }

    @Override
    public int getQuantityCoin () {
        return coinID.size();
    }

    public List<CoinID> getCoinID (){
        return this.coinID;
    }

    @Override
    public List<Ticker> getHistoryCoinInfoFoThePeriod(String idCoin, Period period) {
        List<Ticker> list = new ArrayList<>();
        ResponseEntity <List<Ticker>> response = restTemplate.exchange(builderURL.getHistoricalTickersURL(idCoin, period), HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Ticker>>(){});
        if (response.getStatusCode().is2xxSuccessful()) {
            list = response.getBody();
            if(period.equals(Period.TODAY)){
                ZonedDateTime time = ZonedDateTime.now(ZoneId.of(TIME_ZONE)).minusHours(H24);
                list.removeIf(n ->(n.getTimestamp().isBefore(time)));
            }
            return list;
        }else {log.warn(LOG_MSG);}
        return list;
    }

    @Override
    public Coin getCurrentCoinInfoById (String idCoin) {
        ResponseEntity<Coin> response = restTemplate.exchange(builderURL.getTickersURL(idCoin), HttpMethod.GET,
                null, Coin.class);
        if(response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }else {
            log.warn(LOG_MSG);
        }
        return new Coin();
    }

    @Override
    public List<Coin> getListCoinInfo (Integer start, Integer limit) {
        if (start == 0) {updateCoinIdList();}
        Integer size = getQuantityCoin();
        try {
            if(start<0 || start>=size || limit<=0 || limit>=size || start==limit){ throw new IndexOutOfBoundsException (MSG_EXC);}
            List<Coin> list = new ArrayList<>();
            Coin coin;
            for (int i = start; i < limit + start; i++) {
                if(i==size){break;}
                coin = getCurrentCoinInfoById(coinID.get(i).getId());
                if(coin.getRank() != i+1){
                    log.warn(RANG_CHANGE + coin.getName());
                    updateCoinIdList();
                    coin = getCurrentCoinInfoById(coinID.get(i).getId());
                }
                list.add(coin);
            }
            return list;
        } catch (IndexOutOfBoundsException e) {
            log.warn(MSG_EXC);
            throw e;
        }
    }

    @Override
    public List<CoinOHLC> getCoinOHLCInfoLastFullDay(String idCoin) {
        ResponseEntity<List<CoinOHLC>> response = restTemplate.exchange(builderURL.getCoinOHLCInfoLastDay(idCoin), HttpMethod.GET,
                null, new ParameterizedTypeReference<List<CoinOHLC>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }else {log.warn(LOG_MSG);}
        return new ArrayList<>();
    }

    @Override
    public List<CoinOHLC> getCoinOHLCInfoForToday(String idCoin) {
        ResponseEntity<List<CoinOHLC>> response = restTemplate.exchange(builderURL.getCoinOHLCInfoToday(idCoin), HttpMethod.GET,
                null, new ParameterizedTypeReference<List<CoinOHLC>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }else {log.warn(LOG_MSG);}
        return new ArrayList<>();
    }

    @Override
    public List<CoinOHLC> getHistoryCoinOHLCInfoForThePeriod(String idCoin, Period period) {
        ResponseEntity<List<CoinOHLC>> response = restTemplate.exchange(builderURL.getCoinOHLCInfoPeriod(idCoin, period), HttpMethod.GET,
                null, new ParameterizedTypeReference<List<CoinOHLC>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }else {log.warn(LOG_MSG);}
        return new ArrayList<>();
    }
}
