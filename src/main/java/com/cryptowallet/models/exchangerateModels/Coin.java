package com.cryptowallet.models.exchangerateModels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 * circulating_supply - количество монет находящихся в обращении
 */
public class Coin {
    private String id;
    private String name;
    private String symbol;
    private Long rank;
    @JsonProperty("circulating_supply")
    private Long circulatingSupply;
    @JsonProperty("total_supply")
    private Long totalSupply;
    @JsonProperty("max_supply")
    private Long maxSupply;
    @JsonProperty("last_updated")
    private ZonedDateTime lastUpdated;
    private Map<String, CoinChangeInfo> quotes;
}
