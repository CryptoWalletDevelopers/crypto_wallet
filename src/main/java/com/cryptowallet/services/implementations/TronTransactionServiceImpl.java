package com.cryptowallet.services.implementations;

import com.cryptowallet.API.TronApi;
import com.cryptowallet.crypto.ECKey;
import com.cryptowallet.services.interfaces.TransactionService;
import com.cryptowallet.tronModels.Result;
import com.cryptowallet.tronModels.Transaction;
import com.cryptowallet.wallets.TronWallet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.apache.commons.lang3.SerializationUtils;
import org.spongycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.security.util.Length;
import top.jfunc.json.impl.JSONArray;
import top.jfunc.json.impl.JSONObject;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;

@Component
public class TronTransactionServiceImpl implements TransactionService {

    private TronApi tronApi;
    private TronWallet tronWallet;

    @Autowired
    public TronTransactionServiceImpl(TronApi tronApi, TronWallet tronWallet){
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

        System.out.println(signedTransactionStr);
        System.out.println(stringToHex(signedTransactionStr));

        String rawDataStr = "";
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            rawDataStr = ow.writeValueAsString(signedTransaction.getRawData());
            rawDataStr = rawDataStr.replaceAll("\\s+","");
            rawDataStr = rawDataStr.replaceAll("\\n",",");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject(rawDataStr);

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

//    public Transaction createTransaction(byte[] from, byte[] to, long amount) {
//        Transaction.Builder transactionBuilder = Transaction.newBuilder();
//       // Block newestBlock = WalletApi.getBlock(-1);
//        Block newestBlock = tronApi.getNowBlock();
//        /*set the contract data*/
//        Transaction.Contract.Builder contractBuilder = Transaction.Contract.newBuilder();
//        Contract.TransferContract.Builder transferContractBuilder =
//                Contract.TransferContract.newBuilder();
//        transferContractBuilder.setAmount(amount);
//        ByteString bsTo = ByteString.copyFrom(to);
//        ByteString bsOwner = ByteString.copyFrom(from);
//        transferContractBuilder.setToAddress(bsTo);
//        transferContractBuilder.setOwnerAddress(bsOwner);
//        try {
//            Any any = Any.pack(transferContractBuilder.build());
//            contractBuilder.setParameter(any);
//        } catch (Exception e) {
//            return null;
//        }
//        /*set memo,etc*/
//        contractBuilder.setType(Transaction.Contract.ContractType.TransferContract);
//        transactionBuilder.getRawDataBuilder().addContract(contractBuilder)
//                .setTimestamp(System.currentTimeMillis())
//                .setExpiration(newestBlock.getBlockHeader().getRawData().getTimestamp() + 10 * 60 * 60 * 1000)
//                .setData(ByteString.copyFromUtf8("memo"))
//                .setScripts(ByteString.copyFromUtf8("scripts"));
//        Transaction transaction = transactionBuilder.build();
//        Transaction refTransaction = setReference(transaction, newestBlock);
//        return refTransaction;
//    }

//    public static Transaction setReference(Transaction transaction, Block newestBlock) {
//        long blockHeight = newestBlock.getBlockHeader().getRawData().getNumber();
//        byte[] blockHash = getBlockHash(newestBlock).getBytes();
//        byte[] refBlockNum = ByteArray.fromLong(blockHeight);
//        Transaction.raw rawData = transaction.getRawData().toBuilder()
//                .setRefBlockHash(ByteString.copyFrom(ByteArray.subArray(blockHash, 8, 16)))
//                .setRefBlockBytes(ByteString.copyFrom(ByteArray.subArray(refBlockNum, 6, 8)))
//                .setRefBlockNum(blockHeight)
//                .build();
//        return transaction.toBuilder().setRawData(rawData).build();
//    }
//
//    public static Sha256Sm3Hash getBlockHash(Block block) {
//        return Sha256Sm3Hash.of(block.getBlockHeader().getRawData().toByteArray());
//    }
}
