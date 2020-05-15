package com.cryptowallet.wallets;

import com.cryptowallet.crypto.Base58;
import com.cryptowallet.crypto.ECKey;
import com.cryptowallet.crypto.Sha256Hash;
import com.cryptowallet.entities.Address;
import com.cryptowallet.entities.User;
import com.cryptowallet.services.implementations.AddressServiceImpl;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import io.github.novacrypto.bip32.ExtendedPrivateKey;
import io.github.novacrypto.bip32.networks.Bitcoin;
import io.github.novacrypto.bip44.AddressIndex;
import io.github.novacrypto.bip44.BIP44;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.ArrayList;
import com.cryptowallet.crypto.Protocol.Transaction;

@Component
@Data
@PropertySource("classpath:application.properties")
public class TronWallet extends Wallet implements Generatable {
    private static String secret;
    private static final int COINTYPE = 195;
    private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();
    private AddressServiceImpl addressService;

    @Autowired
    private Environment env;

    @PostConstruct
    public  void setSecret() {
        this.secret = env.getProperty("secret");
    }

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
        return  ECKey.fromPrivate(pk);
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
    public String getStringAddress(ECKey key) {
            return tronString(key.getAddress());
    }

    public String getNewAddress(User user){
            int index = getMaxAddressIndex(user);
            ECKey newKey = getECkey(user.getId() ,index+1);
            return getStringAddress(newKey);
    }

    public int getMaxAddressIndex(User user){
        if(!user.getAddresses().isEmpty()) {
            ArrayList<Address> tmp = new ArrayList<Address>();
            user.getAddresses().stream()
                    .forEach(address -> {
                        if(address.getCurrency().getIndex()==COINTYPE){
                            tmp.add(address);
                        }
                    });
            if (!tmp.isEmpty()){
                int max_index= -1;
                for (Address address : tmp) {
                    if (address.getIndex() > max_index) {
                        max_index = address.getIndex();
                    }
                }
            return max_index;
            }
            else return -1;
        }
        else return -1;
    }

    public static byte[] signTransaction2Byte(byte[] transaction, byte[] privateKey)
            throws InvalidProtocolBufferException {
        ECKey ecKey = ECKey.fromPrivate(privateKey);
        Transaction transaction1 = Transaction.parseFrom(transaction);
        byte[] rawdata = transaction1.getRawData().toByteArray();
        byte[] hash = Sha256Hash.hash(rawdata);
        byte[] sign = ecKey.sign(hash).toByteArray();
        return transaction1.toBuilder().addSignature(ByteString.copyFrom(sign)).build().toByteArray();
    }

    public static Transaction signTransaction2Object(byte[] transaction, byte[] privateKey)
            throws InvalidProtocolBufferException {
        ECKey ecKey = ECKey.fromPrivate(privateKey);
        Transaction transaction1 = Transaction.parseFrom(transaction);
        byte[] rawdata = transaction1.getRawData().toByteArray();
        byte[] hash = Sha256Hash.hash(rawdata);
        byte[] sign = ecKey.sign(hash).toByteArray();
        return transaction1.toBuilder().addSignature(ByteString.copyFrom(sign)).build();
    }

    public byte[] getPrivateKeyFromAddress(String address){
        Address address1 = addressService.findAddressesByAddress(address).get();
        getECkey(address1.getUser().getId(),address1.getIndex());
        return decode58(getPrivateKeyBytes(getECkey(address1.getUser().getId(),address1.getIndex())));
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