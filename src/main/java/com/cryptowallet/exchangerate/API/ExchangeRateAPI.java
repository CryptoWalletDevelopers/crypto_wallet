package com.cryptowallet.exchangerate.API;

import com.cryptowallet.exchangerate.model.Coin;
import com.cryptowallet.exchangerate.model.CoinOHLC;
import com.cryptowallet.exchangerate.model.GlobalInfo;
import com.cryptowallet.exchangerate.model.Ticker;
import com.cryptowallet.exchangerate.model.enumpack.CoinID;
import com.cryptowallet.exchangerate.model.enumpack.Period;

import java.util.List;

public interface ExchangeRateAPI {

    GlobalInfo getGlobalInfo();

    List<Ticker> getHistoryTickerList(CoinID idCoin, Period period);

    Coin getCurrentCoinInfoById (CoinID idCoin);

    List<CoinOHLC> getCoinOHLCInfoLastDay (CoinID idCoin);

    List<CoinOHLC> getCoinOHLCInfoToday (CoinID idCoin);

    List<CoinOHLC> getCoinOHLCHistoryInfo (CoinID idCoin, Period period);
}
