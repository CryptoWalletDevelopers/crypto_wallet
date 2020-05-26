package com.cryptowallet.API.exchangerate;
import com.cryptowallet.models.exchangerateModels.enumpack.Interval;
import com.cryptowallet.models.exchangerateModels.enumpack.Period;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Log4j2
@NoArgsConstructor
public class BuilderURL {
    private final String URL = "https://api.coinpaprika.com/v1/";
    private final String TICKERS = "tickers/";
    private final String HISTORICAL = "/historical";
    private final String OHLCV_LATEST = "/ohlcv/latest/";
    private final String OHLCV_HISTORY = "/ohlcv/historical";
    private final String OHLCV_TODAY = "/ohlcv/today/";
    private final String COINS = "coins/";
    private final String START = "start";
    private final String END = "end";
    private final String LIMIT = "limit";
    private final String INTERVAL = "interval";
    private final Integer ROWS = 5000;
    private final Integer ROWS_OHLC = 366;
    private final String TIME_ZONE = "Z";
    private final String LOG_MSG = "Invalid Period!";

    public String getCoinIdURL () {return URL + COINS;}

    public String getTickersURL(String idCoin) {
        return URL + TICKERS + idCoin;
    }

    public String getCoinOHLCInfoLastDay (String idCoin) {
        return URL + COINS + idCoin + OHLCV_LATEST;
    }

    public String getCoinOHLCInfoToday (String idCoin) {
        return URL + COINS + idCoin + OHLCV_TODAY;
    }

    public String getCoinOHLCInfoPeriod (String idCoin, Period period) {
        String url = URL + COINS + idCoin + OHLCV_HISTORY;
        return setPathVariable(url, period, COINS);
    }

    public String getHistoricalTickersURL (String idCoin, Period period) {
        String url = URL + TICKERS + idCoin + HISTORICAL;
        return setPathVariable(url, period, TICKERS);
    }

    private String setPathVariable (String url, Period period, String type) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        if(type.equals(TICKERS)) {
            builder.queryParam(LIMIT, ROWS);
            builder = getPathVariableHistoricalTickers(builder, period);
        }else if (type.equals(COINS)) {
            builder.queryParam(LIMIT, ROWS_OHLC);
            builder = getPathVariableCoinOHLCInfoPeriod(builder, period);
        }
        System.out.println(builder.toUriString());
        return builder.toUriString();
    }

    private UriComponentsBuilder getPathVariableCoinOHLCInfoPeriod (UriComponentsBuilder builder, Period period) {
        ZonedDateTime time = ZonedDateTime.now(ZoneId.of(TIME_ZONE));
        long value = period.getValue();
        switch (period){
            case TODAY:
                builder.queryParam(START, time.toLocalDate());
                return builder;
            case WEEK:
                builder.queryParam(START, time.minusWeeks(value).toLocalDate());
                return builder;
            case MONTH:
            case MONTH_3:
            case MONTH_6:
                builder.queryParam(START, time.minusMonths(value).toLocalDate());
                return builder;
            case YEAR:
            case YEAR_2:
            case YEAR_3:
                builder.queryParam(START, LocalDateTime.now().minusYears(1L).toLocalDate());//пока так
                return builder;
            default: log.warn(LOG_MSG);
        }
        return builder;
    }

    private UriComponentsBuilder getPathVariableHistoricalTickers (UriComponentsBuilder builder, Period period) {
        ZonedDateTime time = ZonedDateTime.now(ZoneId.of(TIME_ZONE));
        long value = period.getValue();
        switch (period){
            case TODAY:
                builder.queryParam(START, time.minusHours(value).toLocalDate());
                builder.queryParam(INTERVAL, Interval.M5.getValue());
                return builder;
            case WEEK:
                builder.queryParam(START, time.minusWeeks(value).toLocalDate());
                builder.queryParam(INTERVAL, Interval.H1.getValue());
                return builder;
            case MONTH:
                builder.queryParam(START, time.minusMonths(value).toLocalDate());
                builder.queryParam(INTERVAL, Interval.H6.getValue());
                return builder;
            case MONTH_3:
                builder.queryParam(START, time.minusMonths(value).toLocalDate());
                builder.queryParam(INTERVAL, Interval.H12.getValue());
                return builder;
            case MONTH_6:
                builder.queryParam(START, time.minusMonths(value).toLocalDate());
                builder.queryParam(INTERVAL, Interval.H24.getValue());
                return builder;
            case YEAR:
                builder.queryParam(START, time.minusYears(value).toLocalDate());
                builder.queryParam(INTERVAL, Interval.D1.getValue());
                return builder;
            case YEAR_2:
                builder.queryParam(START, time.minusYears(value).toLocalDate());
                builder.queryParam(INTERVAL, Interval.D7.getValue());
                return builder;
            case YEAR_3:
                builder.queryParam(START, time.minusYears(value).toLocalDate());
                builder.queryParam(INTERVAL, Interval.D14.getValue());
                return builder;
            default: log.warn(LOG_MSG);
        }
        return builder;
    }
}
