package com.cryptowallet.wallets;

import com.cryptowallet.crypto.ECKey;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public abstract class Wallet {

    public Wallet(){}

    public abstract ECKey getECkey(int account, int index);

    public abstract String getPrivateKeyBytes(ECKey key);

    public abstract String getAddressBytes(ECKey key);

    public abstract String getStringAddress(ECKey key);
}
