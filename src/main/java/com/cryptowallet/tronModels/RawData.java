package com.cryptowallet.tronModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RawData {
    private Long number;
    private String txTrieRoot;
    @JsonProperty("witness_address")
    private String witnessAddress;
    private String parentHash;
    private Long timestamp;

    private Contract[] contract;
    @JsonProperty("ref_block_bytes")
    private String refBlockBytes;
    @JsonProperty("ref_block_hash")
    private String refBlockHash;
    private Long expiration;
}
