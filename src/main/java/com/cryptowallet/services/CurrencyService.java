package com.cryptowallet.services;

import com.cryptowallet.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
    private CurrencyRepository currencyRepository;

    @Autowired
    public void setCurrencyRepository(CurrencyRepository currencyRepository){
        this.currencyRepository = currencyRepository;
    }
}
