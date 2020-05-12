package com.cryptowallet.tronModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Block {
    private String blockID;
    @JsonProperty("block_header")
    private BlockHeader blockHeader;
    private Transaction[] transactions;
}
