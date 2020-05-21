package com.cryptowallet.services.implementations;

import com.cryptowallet.entities.Currency;
import com.cryptowallet.repositories.CurrencyRepository;
import com.cryptowallet.services.interfaces.CurrencyService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Currency> findCurrencyByIndex(@NonNull int index) {
        return currencyRepository.findCurrencyByIndex(index);
    }

    @Override
    public Currency findCurrencyByTitle(@NonNull String title) {
        return currencyRepository.findCurrencyByTitle(title);
    }

    @Override
    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

}
