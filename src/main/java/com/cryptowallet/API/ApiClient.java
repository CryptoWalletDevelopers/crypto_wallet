package com.cryptowallet.API;

import com.cryptowallet.tronModels.*;
import org.springframework.stereotype.Component;

public abstract class ApiClient {
   // public abstract void getNode();

    public abstract Block getNowBlock();

    public abstract Block getBlockInfoById(String hash);

    public abstract Block getBlockByNum(int number);

    public abstract Transaction getTransactionInfoById(String id);

    public abstract Transaction createTransaction(String to_address, String owner_address, int amount);

    public abstract Result broadcastTransactionHex(String transaction);

    public abstract Account accountInfoByAddress(String address);

    public  abstract AccountInfo getAccountInfoByAddress(String address);
}





