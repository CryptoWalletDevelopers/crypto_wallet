package com.cryptowallet.utils;


import io.github.novacrypto.bip32.derivation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import io.github.novacrypto.bip44.*;
import io.github.novacrypto.bip32.ExtendedPrivateKey;
import io.github.novacrypto.b

import java.security.PrivateKey;


@Component
@Data
@NoArgsConstructor
public  class SeedGenerator {

    private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }


    public static void main(String[] args) {
        String secret = "almost vacuum antenna inside easily chuckle photo damp comfort immense predict pattern";
        byte[] seed = new SeedCalculator().calculateSeed(secret, "");

        String a = "104c1f3fbd04dd819401d84d4fc9f0f2605022505a92c73a28d137d265e42a81a2b0bed470ad54dbe994e40a3b19d40479b62ca2a84340b99fdc764f3a0ec76c";
        System.out.println(bytesToHex(seed));
        System.out.println(a);

        ExtendedPrivateKey rootKey = ExtendedPrivateKey.fromSeed(new SeedCalculator().calculateSeed(secret,""), Bitcoin.TEST_NET);
        AddressIndex account = BIP44
                .m()
                .purpose44()
                .coinType(2)
                .account(1)
                .external()
                .address(5);

//        PrivateKey addressKey = rootKey.derive(account, Account.DERIVATION);
        ExtendedPrivateKey accountPrivate = rootKey.derive(account.toString());
        System.out.println(accountPrivate.toString());
    }
}
