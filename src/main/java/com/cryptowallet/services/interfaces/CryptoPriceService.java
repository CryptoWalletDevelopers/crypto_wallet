package com.cryptowallet.services.interfaces;

import com.cryptowallet.entities.CryptoCoin;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public interface CryptoPriceService {
    List<CryptoCoin> getData(Map<String,String> params);
}
