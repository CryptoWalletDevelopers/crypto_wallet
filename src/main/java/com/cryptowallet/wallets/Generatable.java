package com.cryptowallet.wallets;

import io.github.novacrypto.bip39.SeedCalculator;
import org.springframework.stereotype.Component;

@Component
public interface Generatable {
    default byte [] getSeed(String secret){
        return new SeedCalculator().calculateSeed(secret, "");
    }
}
