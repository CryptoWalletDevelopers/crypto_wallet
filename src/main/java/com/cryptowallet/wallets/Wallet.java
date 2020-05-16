package com.cryptowallet.wallets;

import com.cryptowallet.crypto.ECKey;
import lombok.NonNull;
import org.springframework.stereotype.Component;

public abstract class Wallet {

    public Wallet(){}

    public abstract ECKey getECkey(@NonNull int account, @NonNull int index);

    public abstract String getPrivateKeyBytes(@NonNull ECKey key);

    public abstract String getAddressBytes(@NonNull ECKey key);

    public abstract String getStringAddress(@NonNull ECKey key);
}
