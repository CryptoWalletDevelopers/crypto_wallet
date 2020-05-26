package com.cryptowallet.exchangerate.service;

import com.cryptowallet.exchangerate.API.ExchangeRateAPIImpl;
import com.cryptowallet.exchangerate.model.Coin;
import com.cryptowallet.exchangerate.model.CoinOHLC;
import com.cryptowallet.exchangerate.model.Ticker;
import com.cryptowallet.exchangerate.model.enumpack.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;

@Service
public class ExchangeRateAPIServiceImpl implements ExchangeRateAPIService {
    private ExchangeRateAPIImpl exchangeRateAPIImpl;

    @Autowired
    public ExchangeRateAPIServiceImpl(ExchangeRateAPIImpl exchangeRateAPIImpl) {
        this.exchangeRateAPIImpl = exchangeRateAPIImpl;
    }

    @Override
    public void updateCoinIdList() {exchangeRateAPIImpl.updateCoinIdList();}

    @Override
    public int getQuantityCoin () {
        return exchangeRateAPIImpl.getQuantityCoin();
    }

    @Override
    public List<Coin> getListCoinInfo (Integer start, Integer limit) {
        return exchangeRateAPIImpl.getListCoinInfo(start, limit);
    }

    @Override
    public List<Coin> getReversListCoinInfo (Integer start, Integer limit) {
        List<Coin> list = exchangeRateAPIImpl.getListCoinInfo(start, limit);
        list.sort(Comparator.comparing(Coin::getRank, Comparator.reverseOrder()));
        return list;
    }

    @Override
    public Coin getCurrentCoinInfoById(String idCoin) {
        return exchangeRateAPIImpl.getCurrentCoinInfoById(idCoin);
    }

    @Override
    public List<Ticker> getHistoryCoinInfoFoThePeriod (String idCoin, Period period) {
        try {
            return exchangeRateAPIImpl.getHistoryCoinInfoFoThePeriod(idCoin, period);
        }catch (IndexOutOfBoundsException e) {
            throw e;
        }
    }

    @Override
    public List<CoinOHLC> getCoinOHLCInfoLastFullDay (String idCoin) {
        return exchangeRateAPIImpl.getCoinOHLCInfoLastFullDay(idCoin);
    }

    @Override
    public List<CoinOHLC> getCoinOHLCInfoForToday (String idCoin) {
        return exchangeRateAPIImpl.getCoinOHLCInfoForToday(idCoin);
    }

    @Override
    public List<CoinOHLC> getHistoryCoinOHLCInfoForThePeriod (String idCoin, Period period) {
        return exchangeRateAPIImpl.getHistoryCoinOHLCInfoForThePeriod(idCoin, period);
    }
}
