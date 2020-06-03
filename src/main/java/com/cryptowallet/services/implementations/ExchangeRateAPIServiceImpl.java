package com.cryptowallet.services.implementations;

import com.cryptowallet.API.exchangerate.ExchangeRateAPIImpl;
import com.cryptowallet.models.exchangerateModels.*;
import com.cryptowallet.models.exchangerateModels.enumpack.Period;
import com.cryptowallet.services.interfaces.ExchangeRateAPIService;
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
