package com.cryptowallet.services.implementations;

import com.alibaba.fastjson.JSONObject;
import com.cryptowallet.API.blockchain.TronAPI;
import com.cryptowallet.services.interfaces.TransactionService;
import com.cryptowallet.models.tronModels.Result;
import com.cryptowallet.models.tronModels.Transaction;
import com.cryptowallet.wallets.TronWallet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TronTransactionServiceImpl implements TransactionService {

    private TronAPI tronApi;
    private TronWallet tronWallet;

    @Autowired
    public TronTransactionServiceImpl(TronAPI tronApi, TronWallet tronWallet){
        this.tronApi = tronApi;
        this.tronWallet =  tronWallet;
    }

    @SneakyThrows
    public Result TransferTransaction(String address_to, String address_from, int amount) throws InvalidProtocolBufferException {
        String hex_to = tronWallet.tronHex(address_to);
        String hex_from = tronWallet.tronHex(address_from);
        Transaction transaction = tronApi.createTransaction(hex_to, hex_from, amount);
        Transaction signedTransaction = tronWallet.signTransaction2Byte(transaction,tronWallet.getPrivateKeyFromAddress(address_from));

        String signedTransactionStr = "";
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            signedTransactionStr = ow.writeValueAsString(signedTransaction);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        signedTransactionStr = signedTransactionStr.replaceAll("\\s+","");
        signedTransactionStr = signedTransactionStr.replaceAll("\\n",",");

        String rawDataStr = "";
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            rawDataStr = ow.writeValueAsString(signedTransaction.getRawData());
            rawDataStr = rawDataStr.replaceAll("\\s+","");
            rawDataStr = rawDataStr.replaceAll("\\n",",");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(rawDataStr);

        return tronApi.broadcastTransaction(signedTransaction.getSignature(),signedTransaction.getTxID(), jsonObject, signedTransaction.getRawDataHex());
    }

    public static String stringToHex(String input)
    {
        if (input == null) throw new NullPointerException();
        return asHex(input.getBytes());
    }

    private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
    private static String asHex(byte[] buf)
    {
        char[] chars = new char[2 * buf.length];
        for (int i = 0; i < buf.length; ++i)
        {
            chars[2 * i] = HEX_CHARS[(buf[i] & 0xF0) >>> 4];
            chars[2 * i + 1] = HEX_CHARS[buf[i] & 0x0F];
        }
        return new String(chars);
    }
}
