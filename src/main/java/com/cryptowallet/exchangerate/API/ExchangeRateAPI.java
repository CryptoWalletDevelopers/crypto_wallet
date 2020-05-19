package com.cryptowallet.exchangerate.API;

import com.cryptowallet.exchangerate.BuilderURL;
import com.cryptowallet.exchangerate.model.Coin;
import com.cryptowallet.exchangerate.model.CoinOHLC;
import com.cryptowallet.exchangerate.model.GlobalInfo;
import com.cryptowallet.exchangerate.model.Ticker;
import com.cryptowallet.exchangerate.model.enumpack.CoinID;
import com.cryptowallet.exchangerate.model.enumpack.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Component
@EnableWebMvc
public class ExchangeRateAPI {
    private RestTemplate restTemplate;
    private BuilderURL builderURL;

    @Autowired
    public ExchangeRateAPI (RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.builderURL = new BuilderURL();
    }

    public GlobalInfo getGlobalInfo() {
        return restTemplate.getForObject( builderURL.getGlobalURL(), GlobalInfo.class);
    }

    public List<Ticker> getHistoryTickerList(CoinID idCoin, Period period) {
        List<Ticker> list = restTemplate.exchange(builderURL.getHistoricalTickersURL(idCoin, period), HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Ticker>>(){}).getBody();
        if(period.equals(Period.TODAY)){        //приходится городить, чтобы получить статистику за 24 ч
            ZonedDateTime time = ZonedDateTime.now(ZoneId.of("Z")).minusHours(24L);
            list.removeIf(n ->(n.getTimestamp().isBefore(time)));
        }
        return list;

    }

    public Coin getCurrentCoinInfoById (CoinID idCoin) {
        return restTemplate.getForObject(builderURL.getTickersURL(idCoin), Coin.class);
    }

    public List<CoinOHLC> getCoinOHLCInfoLastDay (CoinID idCoin) {
        return restTemplate.exchange(builderURL.getCoinOHLCInfoLastDay(idCoin), HttpMethod.GET,
                null, new ParameterizedTypeReference<List<CoinOHLC>>() {
                }).getBody();
    }

    public List<CoinOHLC> getCoinOHLCInfoToday (CoinID idCoin) {
        return restTemplate.exchange(builderURL.getCoinOHLCInfoToday(idCoin), HttpMethod.GET,
                null, new ParameterizedTypeReference<List<CoinOHLC>>() {
                }).getBody();
    }

    public List<CoinOHLC> getCoinOHLCHistoryInfo (CoinID idCoin, Period period) {
        return restTemplate.exchange(builderURL.getCoinOHLCInfoPeriod(idCoin, period), HttpMethod.GET,
                null, new ParameterizedTypeReference<List<CoinOHLC>>() {
                }).getBody();
    }
}
