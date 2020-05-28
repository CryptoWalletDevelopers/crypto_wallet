package com.cryptowallet.models.tronModels;

import lombok.Data;

import java.io.Serializable;

@Data
public class Datum implements Serializable {
    private String accountName;
    private AccountResource accountResource;
    private String address;
    private long allowance;
    private V2[] assetV2;
    private long balance;
    private long createTime;
    private V2[] freeAssetNetUsageV2;
    private long freeNetUsage;
    private boolean isWitness;
    private long latestConsumeFreeTime;
    private long latestConsumeTime;
    private long latestOprationTime;
    private long latestWithdrawTime;
}
