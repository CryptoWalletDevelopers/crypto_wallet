package com.cryptowallet.tronModels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Value implements Serializable {
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
