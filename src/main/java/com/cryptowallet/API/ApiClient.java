package com.cryptowallet.API;

import com.cryptowallet.tronModels.Account;
import com.cryptowallet.tronModels.Block;
import com.cryptowallet.tronModels.Result;
import com.cryptowallet.tronModels.Transaction;
import org.springframework.stereotype.Component;

@Component
public abstract class ApiClient {
   // public abstract void getNode();

    public abstract Block getNowBlock();

    public abstract Block getBlockInfoById(String hash);

    public abstract Block getBlockByNum(int number);

    public abstract Transaction getTransactionInfoById(String id);

    public abstract Transaction createTransaction(String to_address, String owner_address, int amount);

    public abstract Result broadcastTransactionHex(String transaction);

    public abstract void transactionIfoByAccountAddress();

    public abstract Account accountInfoByAddress(String address);
}





