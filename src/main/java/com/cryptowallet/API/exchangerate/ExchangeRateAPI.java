package com.cryptowallet.API.exchangerate;

import com.cryptowallet.models.exchangerateModels.*;
import com.cryptowallet.models.exchangerateModels.enumpack.Period;

import java.util.List;

public interface ExchangeRateAPI {

    void updateCoinIdList();

    int getQuantityCoin ();

    List<Ticker> getHistoryCoinInfoFoThePeriod(String idCoin, Period period);

    Coin getCurrentCoinInfoById (String idCoin);

    List<Coin> getListCoinInfo (Integer start, Integer limit);

    List<CoinOHLC> getCoinOHLCInfoLastFullDay(String idCoin);

    List<CoinOHLC> getCoinOHLCInfoForToday(String idCoin);

    List<CoinOHLC> getHistoryCoinOHLCInfoForThePeriod(String idCoin, Period period);
}
