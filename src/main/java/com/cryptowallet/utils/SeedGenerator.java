package com.cryptowallet.utils;

import com.cryptowallet.crypto.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.github.novacrypto.bip44.*;
import io.github.novacrypto.bip32.ExtendedPrivateKey;
import io.github.novacrypto.bip39.SeedCalculator;
import io.github.novacrypto.bip32.networks.Bitcoin;
import java.math.BigInteger;

@Component
@Data
public  class SeedGenerator {
//    @Value(value = "${secret}")
//    public static  String secret;



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
        System.out.println();
        String secret = "almost vacuum antenna inside easily chuckle photo damp comfort immense predict pattern";
        byte[] seed = new SeedCalculator().calculateSeed(secret, "");
        ExtendedPrivateKey rootKey = ExtendedPrivateKey.fromSeed(seed, Bitcoin.TEST_NET);
        AddressIndex addressIndex = BIP44
                .m()
                .purpose44()
                .coinType(0)
                .account(0)
                .external()
                .address(0);

        ExtendedPrivateKey accountPrivate = rootKey.derive(addressIndex.toString());
        BigInteger pk = new BigInteger(bytesToHex(accountPrivate.extendedBase58().getBytes()).substring(0,64), 16);
        ECKey key = ECKey.fromPrivate(pk);

        System.out.println(bytesToHex(key.getPrivKeyBytes()));
        System.out.println(bytesToHex(key.getAddress()));
        System.out.println(tronString(key.getAddress()));



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
        byte[] input1 = new byte[input.length + 4];
        System.arraycopy(input,0, input1,0, input.length);
        System.arraycopy(hash1, 0, input1, input.length , 4);
        return Base58.encode(input1);
    }

}
