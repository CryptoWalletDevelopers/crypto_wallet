package com.cryptowallet.models.tronModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Account implements Serializable {
    @JsonProperty("account_name")
    private String accountname;
    private String address;
    private Asset[] asset;
    private long createTime;
    private long latestOprationTime;
    private long latestConsumeTime;
    private long latestConsumeFreeTime;
    private AccountResource accountResource;
    private Asset[] assetV2;
    private Asset[] freeAssetNetUsageV2;

}
