package com.cryptowallet.utils;

import com.cryptowallet.crypto.Base58;
import com.cryptowallet.crypto.ECKey;
import com.cryptowallet.crypto.Sha256Hash;
import com.cryptowallet.entities.Address;
import com.cryptowallet.entities.User;
import io.github.novacrypto.bip32.ExtendedPrivateKey;
import io.github.novacrypto.bip32.networks.Bitcoin;
import io.github.novacrypto.bip44.AddressIndex;
import io.github.novacrypto.bip44.BIP44;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.math.BigInteger;
import java.util.ArrayList;


@Component
@Data
public class TronWallet extends Wallet implements Generatable {
    @Value("${secret}")
    private static String secret;
    private static final int COINTYPE = 195;
    private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();

        @Override
    public ECKey getECkey(int account, int index) {
        ExtendedPrivateKey rootKey = ExtendedPrivateKey.fromSeed(getSeed(this.secret), Bitcoin.TEST_NET);
        AddressIndex addressIndex = BIP44
                .m()
                .purpose44()
                .coinType(COINTYPE)
                .account(account)
                .external()
                .address(index);
        ExtendedPrivateKey accountPrivate = rootKey.derive(addressIndex.toString());
        BigInteger pk = new BigInteger(bytesToHex(accountPrivate.extendedBase58().getBytes()).substring(0,64), 16);
        ECKey key = ECKey.fromPrivate(pk);
        return key;
    }

    @Override
    public String getPrivateKeyBytes(ECKey key) {
        return bytesToHex(key.getPrivKeyBytes());
    }


    @Override
    public String getAddressBytes(ECKey key) {
        return bytesToHex(key.getAddress());
    }

    @Override
    public String getAddress(ECKey key) {
        return tronString(key.getAddress());
    }

    public String getNewAddress(User user){
            int index = getMaxTronAddressIndex(user);
            ECKey newKey = getECkey(user.getId().intValue() ,index+1);
            String address = getAddress(newKey);
            return address;
    }

    public int getMaxTronAddressIndex(User user){
        ArrayList<Address> userAddresses = (ArrayList<Address>) user.getAddresses();
        if(!userAddresses.isEmpty()) {
            ArrayList<Address> tmp = new ArrayList<>();
            for (Address address : userAddresses) {
                if (address.getCurrency().getIndex() == COINTYPE) {
                    tmp.add(address);
                }
            }
            int max_index = 0;
            for (Address address : tmp) {
                if (address.getIndex() > max_index) {
                    max_index = address.getIndex();
                }
            }
            return max_index;
        }
        else return 0;
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    private static String tronString(byte[] input) {
        byte[] hash0 = Sha256Hash.hash(input);
        byte[] hash1 = Sha256Hash.hash(hash0);
        byte[] input1 = new byte[input.length + 4];
        System.arraycopy(input, 0, input1, 0, input.length);
        System.arraycopy(hash1, 0, input1, input.length, 4);
        return Base58.encode(input1);
    }

    public  String tronHex(String base58) {
        byte[] decoded = decode58(base58);
        String hexString = decoded == null ? "" : org.spongycastle.util.encoders.Hex.toHexString(decoded);
        return hexString;
    }

    private byte[] decode58(String input){
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
}