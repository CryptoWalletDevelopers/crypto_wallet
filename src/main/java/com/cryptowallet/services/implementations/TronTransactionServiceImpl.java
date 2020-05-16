package com.cryptowallet.services.implementations;

import com.cryptowallet.API.TronApi;
import com.cryptowallet.services.interfaces.TransactionService;
import com.cryptowallet.tronModels.Result;
import com.cryptowallet.tronModels.Transaction;
import com.cryptowallet.wallets.TronWallet;
import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TronTransactionServiceImpl implements TransactionService {
    @Autowired
    private TronApi tronApi;
    @Autowired
    private TronWallet tronWallet;

    public Result TransferTransaction(String address_to, String address_from, int amount) throws InvalidProtocolBufferException {
        Transaction transaction = tronApi.createTransaction(address_to,address_from,amount);
        byte[] signedTransaction = tronWallet.signTransaction2Byte(SerializationUtils.serialize(transaction),SerializationUtils.serialize(tronWallet.getPrivateKeyFromAddress(address_from)));
        return tronApi.broadcastTransactionHex(tronWallet.bytesToHex(signedTransaction));
    }
}
