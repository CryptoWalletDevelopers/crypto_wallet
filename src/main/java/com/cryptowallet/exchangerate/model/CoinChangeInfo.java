package com.cryptowallet.exchangerate.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoinChangeInfo {
    private Double price;
    @JsonProperty("volume_24h")
    private Double volume24h;
    @JsonProperty("volume_24h_change_24h")
    private Double volume24hChange24h;
    @JsonProperty("market_cap")
    private Double marketCap;
    @JsonProperty("market_cap_change_24h")
    private Double marketCapChange24h;
    @JsonProperty("percent_change_1h")
    private Double percentChange1h;
    @JsonProperty("percent_change_12h")
    private Double percentChange12h;
    @JsonProperty("percent_change_24h")
    private Double percentChange24h;
    @JsonProperty("percent_change_7d")
    private Double percentChange7d;
    @JsonProperty("percent_change_30d")
    private Double percentChange30d;
    @JsonProperty("percent_change_1y")
    private Double percentChange1y;
}
