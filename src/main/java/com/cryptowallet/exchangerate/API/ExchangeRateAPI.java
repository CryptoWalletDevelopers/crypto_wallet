package com.cryptowallet.exchangerate.API;

import com.cryptowallet.exchangerate.model.*;
import com.cryptowallet.exchangerate.model.enumpack.Period;

import java.util.List;

public interface ExchangeRateAPI {

    void updateCoinIdList();

    List<Ticker> getHistoryCoinInfoFoThePeriod(String idCoin, Period period);

    Coin getCurrentCoinInfoById (String idCoin);

    List<Coin> getListCoinInfo (Integer start, Integer limit);

    List<CoinOHLC> getCoinOHLCInfoLastFullDay(String idCoin);

    List<CoinOHLC> getCoinOHLCInfoForToday(String idCoin);

    List<CoinOHLC> getHistoryCoinOHLCInfoForThePeriod(String idCoin, Period period);
}
