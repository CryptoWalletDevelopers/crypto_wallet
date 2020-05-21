package com.cryptowallet.exchangerate.service;

import com.cryptowallet.exchangerate.API.ExchangeRateAPIImpl;
import com.cryptowallet.exchangerate.model.Coin;
import com.cryptowallet.exchangerate.model.CoinID;
import com.cryptowallet.exchangerate.model.CoinOHLC;
import com.cryptowallet.exchangerate.model.Ticker;
import com.cryptowallet.exchangerate.model.enumpack.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeRateAPIServiceImpl implements ExchangeRateAPIService {

    private ExchangeRateAPIImpl exchangeRateAPIImpl;

    @Autowired
    public ExchangeRateAPIServiceImpl(ExchangeRateAPIImpl exchangeRateAPIImpl) {
        this.exchangeRateAPIImpl = exchangeRateAPIImpl;
    }

    @Override
    public List<CoinID> getCoinIdList () {return exchangeRateAPIImpl.getCoinIdList();}

    @Override
    public List<Coin> getListCoinInfo (Integer start, Integer limit) {
        return exchangeRateAPIImpl.getListCoinInfo(start, limit);
    }

    @Override
    public Coin getCurrentCoinInfo(String idCoin) {
        return exchangeRateAPIImpl.getCurrentCoinInfoById(idCoin);
    }

    @Override
    public List<Ticker> getHistoryCoinInfoFoThePeriod(String idCoin, Period period) {
        return exchangeRateAPIImpl.getHistoryTickerList(idCoin, period);
    }

    @Override
    public List<CoinOHLC> getCoinOHLCInfoLastFullDay (String idCoin) {
        return exchangeRateAPIImpl.getCoinOHLCInfoLastDay(idCoin);
    }

    @Override
    public List<CoinOHLC> getCoinOHLCInfoForToday (String idCoin) {
        return exchangeRateAPIImpl.getCoinOHLCInfoToday(idCoin);
    }

    @Override
    public List<CoinOHLC> getHistoryCoinOHLCInfoForThePeriod (String idCoin, Period period) {
        return exchangeRateAPIImpl.getCoinOHLCHistoryInfo(idCoin, period);
    }
}
