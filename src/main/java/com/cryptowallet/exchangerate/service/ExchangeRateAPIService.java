package com.cryptowallet.exchangerate.service;

import com.cryptowallet.exchangerate.model.Coin;
import com.cryptowallet.exchangerate.model.CoinID;
import com.cryptowallet.exchangerate.model.CoinOHLC;
import com.cryptowallet.exchangerate.model.Ticker;
import com.cryptowallet.exchangerate.model.enumpack.Period;

import java.util.List;

    /**
    * Максимальное количество запросов с одного IP на сервер 10 в 1 секунду
     * все цены приведены в USD
     * время на сервере в нулевом часовом поясе
    */
public interface ExchangeRateAPIService {

    /**
     * Возвращает лист ID валют отсортированных по рангу
     */
    List<CoinID> getCoinIdList ();

    /**
     * Возвращает информацию по валюте на текущий момент,
     * процентное изменение цены за 1ч, 12ч, 24ч, 7 дней, 30 дней, 1 год
     */
    Coin getCurrentCoinInfo(String idCoin);

    /**
     * Возвращает лист валют c рангом от (start + 1) до (start + limit + 1) отсортированный по рангу
     * отсчет массива начинается от 0
     */
    List<Coin> getListCoinInfo(Integer start, Integer limit);

    /**
     * Возвращает информацию по цене, объёму, рыночной капитализации и времени
     * в каждый момент времени с интервалом от 5 минут до недели за указанный период времени
     *  интервал зависит от указанного периода
     *  максимальный размер массива в ответе 5000
     */
    List<Ticker> getHistoryCoinInfoFoThePeriod(String idCoin, Period period);

    /**
     * Статистика за день последний полный (24 ч) день (вчера)
     * Open/High/Low/Close price values with volume and market_cap
     */
    List<CoinOHLC> getCoinOHLCInfoLastFullDay (String idCoin);

    /**
     * Статистика на текущий момент за сегодня (начиная с 00:00)
     * Open/High/Low/Close price values with volume and market_cap
     */
    List<CoinOHLC> getCoinOHLCInfoForToday (String idCoin);

    /**
     * Статистика по каждому дню за указанный период до последнего полного дня включительно,
     * неполный сегодняшний день не входит
     * Open/High/Low/Close price values with volume and market_cap
     * Максимальное количество возвращаемых сервисом в ответе строк 366
     */
    List<CoinOHLC> getHistoryCoinOHLCInfoForThePeriod (String idCoin, Period period);

}
