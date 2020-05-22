package com.cryptowallet.API;

import com.cryptowallet.tronModels.*;
import top.jfunc.json.impl.JSONObject;

public abstract class ApiClient {

    public abstract Block getNowBlock();

    public abstract Block getBlockInfoById(String hash);

    public abstract Block getBlockByNum(int number);

    public abstract Transaction getTransactionInfoById(String id);

    public abstract Transaction createTransaction(String to_address, String owner_address, int amount);

    public abstract Result broadcastTransactionHex(String transaction);

    public abstract Result broadcastTransaction (String[] signature, String txID, JSONObject rawData, String raw_data_hex);

    public abstract Account accountInfoByAddress(String address);

    public  abstract AccountInfo getAccountInfoByAddress(String address);

}





