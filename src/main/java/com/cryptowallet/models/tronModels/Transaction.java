package com.cryptowallet.models.tronModels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Transaction implements Serializable{
    @JsonProperty("Error")
    private String error;
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
