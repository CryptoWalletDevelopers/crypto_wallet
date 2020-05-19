package com.cryptowallet.exchangerate;

import com.cryptowallet.exchangerate.API.ExchangeRateAPI;
import com.cryptowallet.exchangerate.model.Coin;
import com.cryptowallet.exchangerate.model.enumpack.CoinID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ExchangeRateAPIService {

    private ExchangeRateAPI exchangeRateAPI;

    @Autowired
    public ExchangeRateAPIService(ExchangeRateAPI exchangeRateAPI) {
        this.exchangeRateAPI = exchangeRateAPI;
    }

    public List<Coin> getAllCoinInfo () {
        List<Coin> list = new ArrayList<>();
        for (CoinID id: CoinID.values()) {
            list.add(exchangeRateAPI.getCurrentCoinInfoById(id));
        }
        list.sort(Comparator.comparing(Coin::getRank));
        return list;
    }

}
