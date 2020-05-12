package com.cryptowallet.tronModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Transaction {
    private String id;
    private long fee;
    private long blockNumber;
    private long blockTimeStamp;
    private String[] contractResult;
    private Receipt receipt;

    private Ret[] ret;
    private String[] signature;
    private String txID;
    @JsonProperty("raw_data")
    private RawData rawData;
    @JsonProperty("raw_data_hex")
    private String rawDataHex;

    private boolean visible;

}
