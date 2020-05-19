package com.cryptowallet.exchangerateAPI;

import com.cryptowallet.exchangerate.API.ExchangeRateAPIImpl;
import com.cryptowallet.exchangerate.service.ExchangeRateAPIServiceImpl;
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
    private ExchangeRateAPIImpl exchangeRateAPIImpl;
    @Autowired
    private ExchangeRateAPIServiceImpl exchangeRateAPIService;

    @Test
    public void testGlobalInfo () {
        System.out.println(exchangeRateAPIImpl.getGlobalInfo());
    }

    @Test
    public void testListTickers () {
        System.out.println(exchangeRateAPIImpl.getHistoryTickerList(CoinID.BITCOIN, Period.TODAY));
    }

    @Test
    public void testCoinInfo () {
        System.out.println(exchangeRateAPIImpl.getCurrentCoinInfoById(CoinID.BITCOIN));
    }

    @Test
    public void testOHLCLastDay () {
        System.out.println(exchangeRateAPIImpl.getCoinOHLCInfoLastDay(CoinID.BITCOIN));
    }

    @Test
    public void testOHLCToday () {
        System.out.println(exchangeRateAPIImpl.getCoinOHLCInfoToday(CoinID.BITCOIN));
    }

    @Test
    public void testOHLCPeriod () {
        System.out.println(exchangeRateAPIImpl.getCoinOHLCHistoryInfo(CoinID.BITCOIN, Period.WEEK));
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
