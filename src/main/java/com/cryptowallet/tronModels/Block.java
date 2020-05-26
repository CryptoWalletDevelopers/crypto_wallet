package com.cryptowallet.tronModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Block implements Serializable {
    private String blockID;
    @JsonProperty("block_header")
    private BlockHeader blockHeader;
    private Transaction[] transactions;
}
