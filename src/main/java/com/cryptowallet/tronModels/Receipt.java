package com.cryptowallet.tronModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Receipt {
    @JsonProperty("net_fee")
    private Long netFee;
}
