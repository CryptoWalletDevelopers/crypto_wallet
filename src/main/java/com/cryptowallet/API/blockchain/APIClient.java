package com.cryptowallet.API.blockchain;

import com.alibaba.fastjson.JSONObject;
import com.cryptowallet.models.tronModels.*;
import top.jfunc.json.impl.JSONArray;

public abstract class APIClient {

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





