package com.cryptowallet.exchangerate.service;

import com.cryptowallet.exchangerate.API.ExchangeRateAPIImpl;
import com.cryptowallet.exchangerate.model.Coin;
import com.cryptowallet.exchangerate.model.CoinOHLC;
import com.cryptowallet.exchangerate.model.Ticker;
import com.cryptowallet.exchangerate.model.enumpack.CoinID;
import com.cryptowallet.exchangerate.model.enumpack.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Coin> getAllCoinInfo () {
        List<Coin> list = new ArrayList<>();
        for (CoinID id: CoinID.values()) {
            list.add(exchangeRateAPIImpl.getCurrentCoinInfoById(id));
        }
        list.sort(Comparator.comparing(Coin::getRank));
        return list;
    }

    @Override
    public Coin getCurrentCoinInfo(CoinID idCoin) {
        return exchangeRateAPIImpl.getCurrentCoinInfoById(idCoin);
    }

    @Override
    public List<Ticker> getHistoryCoinInfoFoThePeriod(CoinID idCoin, Period period) {
        return exchangeRateAPIImpl.getHistoryTickerList(idCoin, period);
    }

    @Override
    public List<CoinOHLC> getCoinOHLCInfoLastFullDay (CoinID idCoin) {
        return exchangeRateAPIImpl.getCoinOHLCInfoLastDay(idCoin);
    }

    @Override
    public List<CoinOHLC> getCoinOHLCInfoForToday (CoinID idCoin) {
        return exchangeRateAPIImpl.getCoinOHLCInfoToday(idCoin);
    }

    @Override
    public List<CoinOHLC> getHistoryCoinOHLCInfoForThePeriod (CoinID idCoin, Period period) {
        return exchangeRateAPIImpl.getCoinOHLCHistoryInfo(idCoin, period);
    }
}
