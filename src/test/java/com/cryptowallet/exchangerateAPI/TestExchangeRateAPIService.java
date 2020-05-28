package com.cryptowallet.exchangerateAPI;

import com.cryptowallet.models.exchangerateModels.Coin;
import com.cryptowallet.models.exchangerateModels.CoinOHLC;
import com.cryptowallet.models.exchangerateModels.Ticker;
import com.cryptowallet.models.exchangerateModels.enumpack.Period;
import com.cryptowallet.services.implementations.ExchangeRateAPIServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestExchangeRateAPIService {
    private String bitcoinId = "btc-bitcoin";
    private String bitcoinSymbol = "BTC";
    private String bitcoinName = "Bitcoin";
    private Long bitcoinRank = 1L;

    @Autowired
    private ExchangeRateAPIServiceImpl apiService;

    @Test
    public void testCoinIdList () {
        apiService.updateCoinIdList();
        Assert.assertNotNull(apiService.getQuantityCoin());
    }

    @Test
    public void testGetHistoryCoinInfoFoThePeriod () {
        List<Ticker> list = apiService.getHistoryCoinInfoFoThePeriod(bitcoinId, Period.TODAY);
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size()==288);
        ZonedDateTime timeNow = ZonedDateTime.now(ZoneId.of("Z"));
        ZonedDateTime timeYesterday = timeNow.minusHours(24L);
        Assert.assertEquals(timeNow.toLocalDate(), list.get(list.size()-1).getTimestamp().toLocalDate());
        Assert.assertEquals(timeYesterday.toLocalDate(), list.get(0).getTimestamp().toLocalDate());
        System.out.println(list.size());
    }

    @Test
    public void testGetCurrentCoinInfoById () {
        ZonedDateTime timeNow = ZonedDateTime.now(ZoneId.of("Z"));
        Coin bitcoin = apiService.getCurrentCoinInfoById(bitcoinId);
        Assert.assertNotNull(bitcoin);
        Assert.assertEquals(bitcoinId, bitcoin.getId());
        Assert.assertEquals(bitcoinRank, bitcoin.getRank());
        Assert.assertEquals(bitcoinName, bitcoin.getName());
        Assert.assertEquals(bitcoinSymbol, bitcoin.getSymbol());
        Assert.assertEquals(timeNow.toLocalDate(), bitcoin.getLastUpdated().toLocalDate());
        System.out.println(bitcoin);
    }

    @Test
    public void testGetCoinOHLCInfoLastFullDay () {
        ZonedDateTime time = ZonedDateTime.now(ZoneId.of("Z")).minusDays(1);
        List<CoinOHLC> coinOHLC = apiService.getCoinOHLCInfoLastFullDay(bitcoinId);
        Assert.assertNotNull(coinOHLC);
        Assert.assertEquals(1, coinOHLC.size());
        Assert.assertEquals(time.toLocalDate(), coinOHLC.get(0).getTimeOpen().toLocalDate());
        Assert.assertEquals(time.toLocalDate(), coinOHLC.get(0).getTimeClose().toLocalDate());
        System.out.println(coinOHLC);
    }

    @Test
    public void testGetCoinOHLCInfoForToday () {
        ZonedDateTime time = ZonedDateTime.now(ZoneId.of("Z"));
        List<CoinOHLC> coinOHLC = apiService.getCoinOHLCInfoForToday(bitcoinId);
        Assert.assertNotNull(coinOHLC);
        Assert.assertEquals(1, coinOHLC.size());
        Assert.assertEquals(time.toLocalDate(), coinOHLC.get(0).getTimeOpen().toLocalDate());
        Assert.assertEquals(time.toLocalDate(), coinOHLC.get(0).getTimeClose().toLocalDate());
        System.out.println(coinOHLC);
    }

    @Test
    public void testGetHistoryCoinOHLCInfoForThePeriod () {
        ZonedDateTime timeNow = ZonedDateTime.now(ZoneId.of("Z"));
        ZonedDateTime timeWeekAgo = timeNow.minusWeeks(1L);
        List<CoinOHLC> coinOHLC = apiService.getHistoryCoinOHLCInfoForThePeriod(bitcoinId, Period.WEEK);
        Assert.assertNotNull(coinOHLC);
        Assert.assertEquals(8, coinOHLC.size());
        Assert.assertEquals(timeWeekAgo.toLocalDate(), coinOHLC.get(0).getTimeOpen().toLocalDate());
        Assert.assertEquals(timeNow.toLocalDate(), coinOHLC.get(coinOHLC.size()-1).getTimeOpen().toLocalDate());
    }

    @Test
    public void testGetListCoinInfoValid () {
        List<Coin> coinList = apiService.getListCoinInfo(0, 20);
        Assert.assertNotNull(coinList);
        Assert.assertEquals(20, coinList.size());
        Assert.assertEquals(bitcoinId, coinList.get(0).getId());
        System.out.println(coinList);
    }

    @Test
    public void testGetReversListCoinInfoValid () {
        List<Coin> coinList = apiService.getReversListCoinInfo(0, 20);
        Assert.assertNotNull(coinList);
        Assert.assertEquals(20, coinList.size());
        Assert.assertEquals(bitcoinId, coinList.get(19).getId());
        System.out.println(coinList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetListCoinInfoInvalid_N1 () {
        apiService.getListCoinInfo(0, 2500);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetListCoinInfoInvalid_N2 () {
        apiService.getListCoinInfo(2500, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetListCoinInfoInvalid_N3 () {
        apiService.getListCoinInfo(2500, 20);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetListCoinInfoInvalid_N4 () {
        apiService.getListCoinInfo(-20, 20);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetListCoinInfoInvalid_N5 () {
        apiService.getListCoinInfo(20, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetListCoinInfoInvalid_N6 () {
        apiService.getListCoinInfo(2, 2);
    }
}
