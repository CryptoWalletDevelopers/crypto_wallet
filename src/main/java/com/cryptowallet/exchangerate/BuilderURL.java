package com.cryptowallet.exchangerate;

import com.cryptowallet.exchangerate.model.enumpack.CoinID;
import com.cryptowallet.exchangerate.model.enumpack.Interval;
import com.cryptowallet.exchangerate.model.enumpack.Period;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

@Log4j2
public class BuilderURL {
    private final String URL = "https://api.coinpaprika.com/v1/";
    private final String GLOBAL = "global";
    private final String TICKERS = "tickers/";
    private final String HISTORICAL = "/historical";
    private final String OHLCV_LATEST = "/ohlcv/latest/";
    private final String OHLCV_HISTORY = "/ohlcv/historical";
    private final String OHLCV_TODAY = "/ohlcv/today/";
    private final String COINS = "coins/";
    private final String START = "start";
    private final String END = "end";
    private final String LIMIT = "limit";//amount row in response from 1000 to 5000
    private final String INTERVAL = "interval";
    private final Integer ROWS = 5000;

    //https://api.coinpaprika.com/v1/global
    public String getGlobalURL() {
        return URL + GLOBAL;
    }

    //https://api.coinpaprika.com/v1/tickers/btc-bitcoin
    public String getTickersURL(CoinID idCoin) {
        return URL + TICKERS + idCoin.getValue();
    }

    //вчера
    //https://api.coinpaprika.com/v1/coins/{coin_id}/ohlcv/latest/
    public String getCoinOHLCInfoLastDay (CoinID idCoin) {
        return URL + COINS + idCoin.getValue() + OHLCV_LATEST;
    }

    //сегодня
    //https://api.coinpaprika.com/v1/coins/{coin_id}/ohlcv/today/
    public String getCoinOHLCInfoToday (CoinID idCoin) {
        return URL + COINS + idCoin.getValue() + OHLCV_TODAY;
    }

    //https://api.coinpaprika.com/v1/coins/btc-bitcoin/ohlcv/historical?start=2019-01-01&end=2020-01-01
    public String getCoinOHLCInfoPeriod (CoinID idCoin, Period period) {
        String url = URL + COINS + idCoin.getValue() + OHLCV_HISTORY;
        return setPathVariable(url, period, COINS);
    }

    //https://api.coinpaprika.com/v1/tickers/btc-bitcoin/historical?start=2015-09-01&end=2020-05-13&limit=5000&interval=12h
    public String getHistoricalTickersURL (CoinID idCoin, Period period) {
        String url = URL + TICKERS + idCoin.getValue() + HISTORICAL;
        return setPathVariable(url, period, TICKERS);
    }

    private String setPathVariable (String url, Period period, String type) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        if(type.equals(TICKERS)) {
            builder.queryParam(LIMIT, ROWS);
            builder = getPathVariableHistoricalTickers(builder, period);
        }else if (type.equals(COINS)) {
            builder = getPathVariableCoinOHLCInfoPeriod(builder, period);
        }
        System.out.println(builder.toUriString());
        return builder.toUriString();
    }

    // максимальное количество строк в ответе 364, поэтому YEAR_2 и YEAR_3 будут возвращать информацию за год
    // иначе я буду получать информацию в 364 строки с даты START, но не до текущей даты
    private UriComponentsBuilder getPathVariableCoinOHLCInfoPeriod (UriComponentsBuilder builder, Period period) {
        switch (period){
            case TODAY:
                builder.queryParam(START, LocalDateTime.now().toLocalDate());
                builder.queryParam(END, LocalDateTime.now().toLocalDate());
                return builder;
            case WEEK:
                builder.queryParam(START, LocalDateTime.now().minusDays(7L).toLocalDate());
                builder.queryParam(END, LocalDateTime.now().toLocalDate());
                return builder;
            case MONTH:
                builder.queryParam(START, LocalDateTime.now().minusMonths(1L).toLocalDate());
                builder.queryParam(END, LocalDateTime.now().toLocalDate());
                return builder;
            case MONTH_3:
                builder.queryParam(START, LocalDateTime.now().minusMonths(3L).toLocalDate());
                builder.queryParam(END, LocalDateTime.now().toLocalDate());
                return builder;
            case MONTH_6:
                builder.queryParam(START, LocalDateTime.now().minusMonths(6L).toLocalDate());
                builder.queryParam(END, LocalDateTime.now().toLocalDate());
                return builder;
            case YEAR:
            case YEAR_2:
            case YEAR_3:
                builder.queryParam(START, LocalDateTime.now().minusYears(1L).toLocalDate());
                builder.queryParam(END, LocalDateTime.now().toLocalDate());
                return builder;
            default: log.warn("Invalid Period!");
        }
        return builder;
    }

    private UriComponentsBuilder getPathVariableHistoricalTickers (UriComponentsBuilder builder, Period period) {
        switch (period){
            case TODAY:
                builder.queryParam(START, LocalDateTime.now().toLocalDate());
                builder.queryParam(INTERVAL, Interval.M5.getValue());
                return builder;
            case WEEK:
                builder.queryParam(START, LocalDateTime.now().minusDays(7L).toLocalDate());
                builder.queryParam(INTERVAL, Interval.H1.getValue());
                return builder;
            case MONTH:
                builder.queryParam(START, LocalDateTime.now().minusMonths(1L).toLocalDate());
                builder.queryParam(INTERVAL, Interval.H6.getValue());
                return builder;
            case MONTH_3:
                builder.queryParam(START, LocalDateTime.now().minusMonths(3L).toLocalDate());
                builder.queryParam(INTERVAL, Interval.H12.getValue());
                return builder;
            case MONTH_6:
                builder.queryParam(START, LocalDateTime.now().minusMonths(6L).toLocalDate());
                builder.queryParam(INTERVAL, Interval.H24.getValue());
                return builder;
            case YEAR:
                builder.queryParam(START, LocalDateTime.now().minusYears(1L).toLocalDate());
                builder.queryParam(INTERVAL, Interval.D1.getValue());
                return builder;
            case YEAR_2:
                builder.queryParam(START, LocalDateTime.now().minusYears(2L).toLocalDate());
                builder.queryParam(INTERVAL, Interval.D1.getValue());
                return builder;
            case YEAR_3:
                builder.queryParam(START, LocalDateTime.now().minusYears(3L).toLocalDate());
                builder.queryParam(INTERVAL, Interval.D7.getValue());
                return builder;
            default: log.warn("Invalid Period!");
        }
        return builder;
    }
}
