package com.cryptowallet.tronModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BlockHeader {
    @JsonProperty("raw_data")
    private RawData rawData;
    @JsonProperty("witness_signature")
    private String witnessSignature;


}
