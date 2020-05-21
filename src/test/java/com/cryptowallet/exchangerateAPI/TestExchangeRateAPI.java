package com.cryptowallet.exchangerateAPI;

import com.cryptowallet.exchangerate.API.ExchangeRateAPIImpl;
import com.cryptowallet.exchangerate.service.ExchangeRateAPIServiceImpl;
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
    private String bitcoinId = "btc-bitcoin";
    @Autowired
    private ExchangeRateAPIImpl exchangeRateAPIImpl;
    @Autowired
    private ExchangeRateAPIServiceImpl exchangeRateAPIService;

    @Test
    public void testCoinIdList () {
        System.out.println(exchangeRateAPIImpl.getCoinIdList());
    }

    @Test
    public void testGlobalInfo () {
        System.out.println(exchangeRateAPIImpl.getGlobalInfo());
    }

    @Test
    public void testListTickers () {
        System.out.println(exchangeRateAPIImpl.getHistoryTickerList(bitcoinId, Period.TODAY));
    }

    @Test
    public void testCoinInfo () {
        System.out.println(exchangeRateAPIImpl.getCurrentCoinInfoById(bitcoinId));
    }

    @Test
    public void testOHLCLastDay () {
        System.out.println(exchangeRateAPIImpl.getCoinOHLCInfoLastDay(bitcoinId));
    }

    @Test
    public void testOHLCToday () {
        System.out.println(exchangeRateAPIImpl.getCoinOHLCInfoToday(bitcoinId));
    }

    @Test
    public void testOHLCPeriod () {
        System.out.println(exchangeRateAPIImpl.getCoinOHLCHistoryInfo(bitcoinId, Period.WEEK));
    }

    @Test
    public void testGetCoinInfo () {
        System.out.println(exchangeRateAPIService.getListCoinInfo(21, 40));
    }
}
