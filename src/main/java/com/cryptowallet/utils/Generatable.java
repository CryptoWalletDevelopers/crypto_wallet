package com.cryptowallet.utils;

import io.github.novacrypto.bip39.SeedCalculator;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public interface Generatable {
 //  public static String secret = "almost vacuum antenna inside easily chuckle photo damp comfort immense predict pattern";

    default byte [] getSeed(String secret){
        return new SeedCalculator().calculateSeed(secret, "");
    }
}
