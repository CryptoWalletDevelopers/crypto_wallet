package com.cryptowallet.services.interfaces;

import com.cryptowallet.entities.CryptoCoin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CryptoPriceService {
    List<CryptoCoin> getData();
}
