package com.cryptowallet.tronModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BlockHeader implements Serializable {
    @JsonProperty("raw_data")
    private RawData rawData;
    @JsonProperty("witness_signature")
    private String witnessSignature;


}
