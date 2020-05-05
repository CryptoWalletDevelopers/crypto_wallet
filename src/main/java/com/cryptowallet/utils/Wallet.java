package com.cryptowallet.utils;

import com.cryptowallet.crypto.Base58;
import com.cryptowallet.crypto.ECKey;
import com.cryptowallet.crypto.Sha256Hash;
import com.cryptowallet.entities.Address;
import com.cryptowallet.entities.Currency;
import com.cryptowallet.entities.User;
import io.github.novacrypto.bip32.ExtendedPrivateKey;
import io.github.novacrypto.bip32.Network;
import io.github.novacrypto.bip44.AddressIndex;
import io.github.novacrypto.bip44.BIP44;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.math.BigInteger;
import static com.cryptowallet.utils.SeedGenerator.bytesToHex;

@Component
@Data
public abstract class Wallet {

    public Wallet(){}

    public abstract ECKey getECkey(int account, int index);

    public abstract String getPrivateKeyBytes(ECKey key);

    public abstract String getAddressBytes(ECKey key);

    public abstract String getStringAddress(ECKey key);
}
