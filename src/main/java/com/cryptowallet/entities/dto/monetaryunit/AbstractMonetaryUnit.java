package com.cryptowallet.entities.dto.monetaryunit;

import com.cryptowallet.entities.dto.BasicJson;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
abstract class AbstractMonetaryUnit implements BasicJson, Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty
    private BigDecimal price;
    @JsonProperty
    private BigDecimal volume_24h;
    @JsonProperty
    private BigDecimal percent_change_1h;
    @JsonProperty
    private BigDecimal percent_change_24h;
    @JsonProperty
    private BigDecimal percent_change_7d;
    @JsonProperty
    private BigDecimal market_cap;
    @JsonProperty
    private Date last_updated;
}
