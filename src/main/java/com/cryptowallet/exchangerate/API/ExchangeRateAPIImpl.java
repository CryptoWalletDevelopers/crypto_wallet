package com.cryptowallet.exchangerate.API;

import com.cryptowallet.exchangerate.BuilderURL;
import com.cryptowallet.exchangerate.model.*;
import com.cryptowallet.exchangerate.model.enumpack.Period;
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
    private RestTemplate restTemplate;
    private BuilderURL builderURL;
    private List<CoinID> coinID;

    @Autowired
    public ExchangeRateAPIImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.builderURL = new BuilderURL();
        getCoinIdList();
    }

    @Override
    public List<CoinID> getCoinIdList () {
        ResponseEntity <List<CoinID>> response = restTemplate.exchange(builderURL.getCoinIdURL(), HttpMethod.GET,
                null, new ParameterizedTypeReference<List<CoinID>>(){});
        if(response.getStatusCode().is2xxSuccessful()) {
            this.coinID = response.getBody();
            coinID.removeIf(c ->(c.getRank().equals(0)));
            return coinID;
        }else {
            log.warn(LOG_MSG);
        }
        return new ArrayList<>();
    }

    @Override
    public GlobalInfo getGlobalInfo() {
        ResponseEntity<GlobalInfo> response = restTemplate.exchange(builderURL.getGlobalURL(), HttpMethod.GET,
                null, GlobalInfo.class);
        if(response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }else {
            log.warn(LOG_MSG);
        }
        return new GlobalInfo();
    }

    @Override
    public List<Ticker> getHistoryTickerList(String idCoin, Period period) {
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

    public List<Coin> getListCoinInfo (Integer start, Integer limit) {
        if (start == 0) {getCoinIdList();}
        List<Coin> list = new ArrayList<>();
        for (int i = start; i < limit; i++) {
            list.add(getCurrentCoinInfoById(coinID.get(i).getId()));
        }
        return list;
    }

    @Override
    public List<CoinOHLC> getCoinOHLCInfoLastDay (String idCoin) {
        ResponseEntity<List<CoinOHLC>> response = restTemplate.exchange(builderURL.getCoinOHLCInfoLastDay(idCoin), HttpMethod.GET,
                null, new ParameterizedTypeReference<List<CoinOHLC>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }else {log.warn(LOG_MSG);}
        return new ArrayList<>();
    }

    @Override
    public List<CoinOHLC> getCoinOHLCInfoToday (String idCoin) {
        ResponseEntity<List<CoinOHLC>> response = restTemplate.exchange(builderURL.getCoinOHLCInfoToday(idCoin), HttpMethod.GET,
                null, new ParameterizedTypeReference<List<CoinOHLC>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }else {log.warn(LOG_MSG);}
        return new ArrayList<>();
    }

    @Override
    public List<CoinOHLC> getCoinOHLCHistoryInfo (String idCoin, Period period) {
        ResponseEntity<List<CoinOHLC>> response = restTemplate.exchange(builderURL.getCoinOHLCInfoPeriod(idCoin, period), HttpMethod.GET,
                null, new ParameterizedTypeReference<List<CoinOHLC>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }else {log.warn(LOG_MSG);}
        return new ArrayList<>();
    }
}
