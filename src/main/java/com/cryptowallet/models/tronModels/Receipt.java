package com.cryptowallet.models.tronModels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Receipt implements Serializable {
    @JsonProperty("net_fee")
    private Long netFee;
}
