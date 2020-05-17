package com.cryptowallet.exchangerateAPI;

import com.cryptowallet.exchangerate.API.ExchangeRateAPI;
import com.cryptowallet.exchangerate.model.enumpack.CoinID;
import com.cryptowallet.exchangerate.model.enumpack.Period;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestExchangeRateAPI {
    @Autowired
    private ExchangeRateAPI exchangeRateAPI;

    @Test
    public void testGlobalInfo () {
        System.out.println(exchangeRateAPI.getGlobalInfo());
    }

    @Test
    public void testListTickers () {
        System.out.println(exchangeRateAPI.getHistoryTickerList(CoinID.BITCOIN, Period.WEEK));
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
}
