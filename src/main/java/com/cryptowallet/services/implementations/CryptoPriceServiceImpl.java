package com.cryptowallet.services.implementations;

import com.cryptowallet.entities.CryptoCoin;
import com.cryptowallet.entities.dto.cryptoCoinDTO.DataDTO;
import com.cryptowallet.services.CryptoCoinExchangeClient;
import com.cryptowallet.services.interfaces.CryptoPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CryptoPriceServiceImpl implements CryptoPriceService {

    private final CryptoCoinExchangeClient cryptoCoinExchangeClient;

    @Autowired
    public CryptoPriceServiceImpl(CryptoCoinExchangeClient cryptoCoinExchangeClient) {
        this.cryptoCoinExchangeClient = cryptoCoinExchangeClient;
    }

    @Override
    public List<CryptoCoin> getData(Map<String, String> params){
        return cryptoCoinExchangeClient.getCryptoCoins(params).stream()
                .map(this::toCryptoCoin)
                .collect(Collectors.toList());
    }

    private CryptoCoin toCryptoCoin(DataDTO dataDTO) {
        return CryptoCoin.builder()
                .name(dataDTO.getName())
                .price(dataDTO.getQuoteDTO().getUsd().getPrice())
                .symbol(dataDTO.getSymbol())
                .percentChang1h(dataDTO.getQuoteDTO().getUsd().getPercent_change_1h())
                .percentChang24h(dataDTO.getQuoteDTO().getUsd().getPercent_change_24h())
                .percentChang7d(dataDTO.getQuoteDTO().getUsd().getPercent_change_7d())
                .build();
    }
}
