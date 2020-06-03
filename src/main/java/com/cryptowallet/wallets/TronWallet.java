package com.cryptowallet.wallets;

import com.cryptowallet.crypto.*;
import com.cryptowallet.entities.Address;
import com.cryptowallet.entities.User;
import com.cryptowallet.services.implementations.AddressServiceImpl;
import io.github.novacrypto.bip32.ExtendedPrivateKey;
import io.github.novacrypto.bip32.networks.Bitcoin;
import io.github.novacrypto.bip44.AddressIndex;
import io.github.novacrypto.bip44.BIP44;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.DLSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;


@Component
@PropertySource("classpath:application.properties")
public class TronWallet extends Wallet implements Generatable {
    private static String secret;
    private static final int COINTYPE = 195;
    private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();
    private AddressServiceImpl addressService;

    @Autowired
    public TronWallet(AddressServiceImpl addressService, Environment env){
        this.addressService = addressService;
        this.env = env;
    }

    public static ECKey.ECDSASignature decodeFromDER(byte[] bytes) {
        ASN1InputStream decoder = null;
        try {
            decoder = new ASN1InputStream(bytes);
            DLSequence seq = (DLSequence) decoder.readObject();
            if (seq == null) {
                throw new RuntimeException("Reached past end of ASN.1 " +
                        "stream.");
            }
            ASN1Integer r, s;
            try {
                r = (ASN1Integer) seq.getObjectAt(0);
                s = (ASN1Integer) seq.getObjectAt(1);
            } catch (ClassCastException e) {
                throw new IllegalArgumentException(e);
            }
            return new ECKey.ECDSASignature(r.getPositiveValue(), s
                    .getPositiveValue());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (decoder != null) {
                try {
                    decoder.close();
                } catch (IOException x) {
                }
            }
        }
    }


    private static ECKey.ECDSASignature fromComponents(byte[] r, byte[] s) {
        return new ECKey.ECDSASignature(new BigInteger(1, r), new BigInteger(1,
                s));
    }


    public static ECKey.ECDSASignature fromComponents(byte[] r, byte[] s, byte
            v) {
        ECKey.ECDSASignature signature = fromComponents(r, s);
        signature.v = v;
        return signature;
    }

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


    public com.cryptowallet.models.tronModels.Transaction signTransaction2Byte(com.cryptowallet.models.tronModels.Transaction transaction, byte[] privateKey) throws Exception {
        ECKey ecKey = ECKey.fromPrivate(privateKey);
        byte[] hash = hexStr2byteArray(transaction.getTxID(), 32);
        byte[] sign = hexStr2byteArray(ecKey.sign(hash).toHex(), 65);
        String[] signatureObject = new String[1];
        signatureObject[0] = bytesToHex(sign);
        transaction.setSignature(signatureObject);
        return transaction;
    }

    public byte[] hexStr2byteArray(String str, int n) throws Exception {
        byte[] byteArray = new byte[n];
        int d = 0;
        int j = 0;
        int k = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (isHexChar(c)) {
                d <<= 4;
                d += hexChar2byte(c);
                j++;

                if (0 == (j % 2)) {

                    byteArray[k++] = (byte)d;
                    d = 0;
                }
            } else
                throw new Exception("The passed hex char is not a valid hex string");
        }

        return byteArray;
    }

    public int hexChar2byte(char c) throws Exception {
        int d = -1;

        if (c >= 'A' && c <= 'F')
            d = Character.toString(c).charAt(0) - Character.toString('A').charAt(0) + 10;
        else if (c >= 'a' && c <= 'f')
            d = Character.toString(c).charAt(0) - Character.toString('a').charAt(0) + 10;
        else if (c >= '0' && c <= '9')
            d = Character.toString(c).charAt(0) - Character.toString('0').charAt(0);

        if(d == -1){
            throw new Exception("hexChar2byte incorrect char");
        }
        return d;
    }

    public Boolean isHexChar(char c) {
        if ((c >= 'A' && c <= 'F') ||
                (c >= 'a' && c <= 'f') ||
                (c >= '0' && c <= '9')) {
            return true;
        }

        return false;
    }

    public byte[] getPrivateKeyFromAddress(String address){
        Address address1 = addressService.findAddressesByAddress(address).get();
        return ByteUtil.hexToBytes(getPrivateKeyBytes(getECkey(address1.getUser().getId(),address1.getIndex())));
    }

    public String bytesToHex(byte[] bytes) {
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