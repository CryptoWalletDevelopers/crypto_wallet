package com.cryptowallet.exchangerate.API;

import com.cryptowallet.exchangerate.model.*;
import com.cryptowallet.exchangerate.model.enumpack.Period;

import java.util.List;

public interface ExchangeRateAPI {

    List<CoinID> getCoinIdList ();

    GlobalInfo getGlobalInfo();

    List<Ticker> getHistoryTickerList(String idCoin, Period period);

    Coin getCurrentCoinInfoById (String idCoin);

    List<CoinOHLC> getCoinOHLCInfoLastDay (String idCoin);

    List<CoinOHLC> getCoinOHLCInfoToday (String idCoin);

    List<CoinOHLC> getCoinOHLCHistoryInfo (String idCoin, Period period);
}
