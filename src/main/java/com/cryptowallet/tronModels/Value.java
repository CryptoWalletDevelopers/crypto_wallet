package com.cryptowallet.tronModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Value {
    private String data;
    @JsonProperty("owner_address")
    private String ownerAddress;
    private String contractAddress;
    private Long callValue;
    private Long amount;
    @JsonProperty("to_address")
    private String toAddress;
    @JsonProperty("asset_name")
    private String assetName;
    private Vote[] votes;
}
