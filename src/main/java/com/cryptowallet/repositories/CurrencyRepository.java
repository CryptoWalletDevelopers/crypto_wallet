package com.cryptowallet.repositories;

import com.cryptowallet.entities.Currency;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<Currency> findCurrencyByIndex(@NonNull int index);
    Currency findCurrencyByTitle(@NonNull String title);
    Optional<Currency> findCurrencyByShortTitle(@NonNull String shortTitle);
 //   @Query("select short_title from currency;")
  //  List<String> findAllShortNames();
}
