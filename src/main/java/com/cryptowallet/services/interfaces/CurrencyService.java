package com.cryptowallet.services.interfaces;

import com.cryptowallet.entities.Currency;
import com.cryptowallet.repositories.CurrencyRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public interface CurrencyService {
    void save (@NonNull Currency currency);
    Optional<Currency> findCurrencyByIndex(@NonNull int index);
    Optional<Currency> findCurrencyByTitle(@NonNull String title);
}
