package com.cryptowallet.utils;

import com.cryptowallet.crypto.Base58;
import com.cryptowallet.crypto.ByteArray;
import com.cryptowallet.crypto.ECKey;
import com.cryptowallet.crypto.Sha256Hash;
import io.github.novacrypto.bip32.derivation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.spongycastle.asn1.sec.SECNamedCurves;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.springframework.stereotype.Component;
import io.github.novacrypto.bip44.*;
import io.github.novacrypto.bip32.ExtendedPrivateKey;
import io.github.novacrypto.bip39.SeedCalculator;
import io.github.novacrypto.bip32.networks.Bitcoin;
import java.math.BigInteger;

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

        ExtendedPrivateKey rootKey = ExtendedPrivateKey.fromSeed(seed, Bitcoin.TEST_NET);
        AddressIndex addressIndex = BIP44
                .m()
                .purpose44()
                .coinType(0)
                .account(0)
                .external()
                .address(0);

        ExtendedPrivateKey accountPrivate = rootKey.derive(addressIndex.toString());
        BigInteger pk = new BigInteger(bytesToHex(accountPrivate.extendedBase58().getBytes()), 16);

        ECKey key = new ECKey(accountPrivate.extendedBase58().getBytes(), true);
        System.out.println(key.isPubKeyCanonical());
        System.out.println(bytesToHex(key.getPubKey()));
        System.out.println(bytesToHex(key.getPrivKeyBytes()));

        System.out.println(bytesToHex(key.getAddress()));

        System.out.println(tronHex("TFNVLMmwttCaBLkecWJQRAwWuDyjAxxyBK"));


//        Account account = BIP44
//                .m()
//                .purpose44()
//                .coinType(0)
//                .account(0);
//        ExtendedPrivateKey addressKey = rootKey.derive(account, Account.DERIVATION);
//      //  System.out.println(addressKey.extendedBase58());
    }

    public static String tronHex(String base58) {
        byte[] decoded = decode58(base58);
        String hexString = decoded == null ? "" : org.spongycastle.util.encoders.Hex.toHexString(decoded);
        return hexString;
    }

    private static byte[] decode58(String input){
        byte[] decodeCheck = Base58.decode(input);
        if (decodeCheck.length <= 4) {
            return null;
        }
        byte[] decodeData = new byte[decodeCheck.length - 4];
        System.arraycopy(decodeCheck, 0, decodeData, 0, decodeData.length);
        byte[] hash0 = Sha256Hash.hash(decodeData);
        byte[] hash1 = Sha256Hash.hash(hash0);
        if (hash1[0] == decodeCheck[decodeData.length] &&
                hash1[1] == decodeCheck[decodeData.length + 1] &&
                hash1[2] == decodeCheck[decodeData.length + 2] &&
                hash1[3] == decodeCheck[decodeData.length + 3]) {
          return decodeData;
        }
        return null;
    }

    private static String tronString(byte[] input){
        byte[] hash0 = Sha256Hash.hash(input);
        byte[] hash1 = Sha256Hash.hash(hash0);

        // посчитать checksum от hash1, взять 4 байта и добавить в конец к hash1
//        byte[] checksum = Sha256Hash.hashTwice(input, 0, 4);
//        System.arraycopy(checksum, 0, hash1, payload.length + 1, 4);

        return Base58.encode(hash1);
    }
}
