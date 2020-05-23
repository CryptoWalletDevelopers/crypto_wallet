package com.cryptowallet.exchangerateAPI;

import com.cryptowallet.exchangerate.API.ExchangeRateAPIImpl;
import com.cryptowallet.exchangerate.model.CoinID;
import com.cryptowallet.exchangerate.model.Ticker;
import com.cryptowallet.exchangerate.model.enumpack.Period;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestExchangeRateAPI {
    private String bitcoinId = "btc-bitcoin";

    @Autowired
    private ExchangeRateAPIImpl exchangeRateAPIImpl;

    @Test
    public void testCoinIdList () {
        List<CoinID> coinIdList = exchangeRateAPIImpl.getCoinIdList();
        System.out.println(coinIdList);
        Assert.assertTrue(coinIdList.get(0).getRank().equals(1));
        Assert.assertTrue(coinIdList.get(0).getId().equals(bitcoinId));
        Assert.assertTrue(coinIdList.get(coinIdList.size()-1).getRank().equals(coinIdList.size()));
    }

//    @Test
//    public void testGlobalInfo () {
//        System.out.println(exchangeRateAPIImpl.getGlobalInfo());
//    }

    @Test
    public void testHistoryTickerList () {
        List<Ticker> list = exchangeRateAPIImpl.getHistoryCoinInfoFoThePeriod(bitcoinId, Period.TODAY);
        Assert.assertTrue(list.size()==288);
        System.out.println(list.get(0).getTimestamp());
        System.out.println(list.get(0).getTimestamp().plusHours(24L));
        System.out.println(list.get(list.size()-1).getTimestamp());
        System.out.println(list.size());
    }

    @Test
    public void testCoinInfo () {
        System.out.println(exchangeRateAPIImpl.getCurrentCoinInfoById(bitcoinId));
    }

    @Test
    public void testOHLCLastDay () {
        System.out.println(exchangeRateAPIImpl.getCoinOHLCInfoLastFullDay(bitcoinId));
    }

    @Test
    public void testOHLCToday () {
        System.out.println(exchangeRateAPIImpl.getCoinOHLCInfoForToday(bitcoinId));
    }

    @Test
    public void testOHLCPeriod () {
        System.out.println(exchangeRateAPIImpl.getHistoryCoinOHLCInfoForThePeriod(bitcoinId, Period.WEEK));
    }

    @Test()
    public void testGetListCoinInfoValid () {
        System.out.println(exchangeRateAPIImpl.getListCoinInfo(0, 20));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetListCoinInfoInvalid () {
        System.out.println(exchangeRateAPIImpl.getListCoinInfo(0, 0));
        System.out.println(exchangeRateAPIImpl.getListCoinInfo(0, 2500));
        System.out.println(exchangeRateAPIImpl.getListCoinInfo(2500, 20));
    }
}
