package com.cryptowallet.exchangerate.service;

import com.cryptowallet.exchangerate.model.Coin;
import com.cryptowallet.exchangerate.model.CoinOHLC;
import com.cryptowallet.exchangerate.model.Ticker;
import com.cryptowallet.exchangerate.model.enumpack.CoinID;
import com.cryptowallet.exchangerate.model.enumpack.Period;

import java.util.List;

public interface ExchangeRateAPIService {

    /**
     * Возвращает информацию по валюте на текущий момент,
     * процентное изменение цены за 1ч, 12ч, 24ч, 7 дней, 30 дней, 1 год
     */
    Coin getCurrentCoinInfo(CoinID idCoin);

    /**
     * Возвращает отсортированный по рангу лист валют из enum CoinID
     */
    List<Coin> getAllCoinInfo ();

    /**
     * Возвращает информацию по цене, объёму, рыночной капитализации и времени
     * в каждый момент времени с интервалом от 5 минут до недели за указанный период времени
     *  интервал зависит от указанного периода
     */
    List<Ticker> getHistoryCoinInfoFoThePeriod(CoinID idCoin, Period period);

    /**
     * Статистика за день последний полный (24 ч) день (вчера)
     * Open/High/Low/Close price values with volume and market_cap
     */
    List<CoinOHLC> getCoinOHLCInfoLastFullDay (CoinID idCoin);

    /**
     * Статистика на текущий момент за сегодня (начиная с 00:00)
     * Open/High/Low/Close price values with volume and market_cap
     */
    List<CoinOHLC> getCoinOHLCInfoForToday (CoinID idCoin);

    /**
     * Статистика по каждому дню за указанный период до последнего полного дня включительно,
     * неполный сегодняшний день не входит
     * Open/High/Low/Close price values with volume and market_cap
     * Максимальное количество возвращаемых сервисом в ответе строк 366
     */
    List<CoinOHLC> getHistoryCoinOHLCInfoForThePeriod (CoinID idCoin, Period period);

}
