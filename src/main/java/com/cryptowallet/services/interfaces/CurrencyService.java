package com.cryptowallet.services.interfaces;

import com.cryptowallet.entities.Currency;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


@Component
public interface CurrencyService {
    void save (@NonNull Currency currency);
    Optional<Currency> findCurrencyByIndex(@NonNull int index);
    Optional<Currency> findCurrencyByTitle(@NonNull String title);
    Optional<Currency> findCurrencyByShortTitle(@NonNull String shortTitle);
    List<Currency> findAll();
}
