package com.cryptowallet.exchangerateAPI;

import com.cryptowallet.exchangerate.API.ExchangeRateAPI;
import com.cryptowallet.exchangerate.ExchangeRateAPIService;
import com.cryptowallet.exchangerate.model.enumpack.CoinID;
import com.cryptowallet.exchangerate.model.enumpack.Period;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestExchangeRateAPI {
    @Autowired
    private ExchangeRateAPI exchangeRateAPI;
    @Autowired
    private ExchangeRateAPIService exchangeRateAPIService;

    @Test
    public void testGlobalInfo () {
        System.out.println(exchangeRateAPI.getGlobalInfo());
    }

    @Test
    public void testListTickers () {
        System.out.println(exchangeRateAPI.getHistoryTickerList(CoinID.BITCOIN, Period.TODAY));
    }

    @Test
    public void testCoinInfo () {
        System.out.println(exchangeRateAPI.getCurrentCoinInfoById(CoinID.BITCOIN));
    }

    @Test
    public void testOHLCLastDay () {
        System.out.println(exchangeRateAPI.getCoinOHLCInfoLastDay(CoinID.BITCOIN));
    }

    @Test
    public void testOHLCToday () {
        System.out.println(exchangeRateAPI.getCoinOHLCInfoToday(CoinID.BITCOIN));
    }

    @Test
    public void testOHLCPeriod () {
        System.out.println(exchangeRateAPI.getCoinOHLCHistoryInfo(CoinID.BITCOIN, Period.WEEK));
    }

    @Test
    public void testGetAllCoinInfo () {
        System.out.println(exchangeRateAPIService.getAllCoinInfo());
    }

    @Test
    public void testDate () {
//        LocalDateTime dateTime = LocalDateTime.now().minusHours(24L);
        LocalDateTime date = LocalDateTime.now();
//        System.out.println(dateTime);
        System.out.println(date);
//        System.out.println(dateTime.isBefore(date));//true
        System.out.println(date.atZone(ZoneId.of("Z")).getOffset().getId().replace("Z", "+00:00"));
        System.out.println(ZonedDateTime.now().toLocalDate());
        System.out.println("z  "+ZonedDateTime.now(ZoneId.of("Z")));
        System.out.println("z  "+ZonedDateTime.now(ZoneId.of("Z")).getHour());
        System.out.println(ZonedDateTime.now(ZoneId.of("Pacific/Auckland")));

    }
}
