package com.cryptowallet.services;

import com.cryptowallet.entities.Currency;
import com.cryptowallet.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
    private CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository){
        this.currencyRepository = currencyRepository;
    }

    public void save (Currency currency){
        currencyRepository.save(currency);
    }
}
