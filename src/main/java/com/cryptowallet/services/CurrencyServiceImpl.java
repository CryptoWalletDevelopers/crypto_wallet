package com.cryptowallet.services;

import com.cryptowallet.entities.Currency;
import com.cryptowallet.repositories.CurrencyRepository;
import com.cryptowallet.services.interfaces.CurrencyService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository){

        this.currencyRepository = currencyRepository;
    }

    @Override
    public void save (@NonNull Currency currency){
        currencyRepository.save(currency);
    }
}
