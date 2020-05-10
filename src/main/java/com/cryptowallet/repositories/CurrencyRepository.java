package com.cryptowallet.repositories;

import com.cryptowallet.entities.Currency;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<Currency> findCurrencyByIndex(@NonNull int index);
    Optional<Currency> findCurrencyByTitle(@NonNull String title);
}
