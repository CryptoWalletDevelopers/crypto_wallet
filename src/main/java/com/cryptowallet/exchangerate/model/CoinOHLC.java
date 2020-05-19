package com.cryptowallet.exchangerate.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 * Статистика за день
 * Open/High/Low/Close price values with volume and market_cap
 */
public class CoinOHLC {
    @JsonProperty("time_open")
    private ZonedDateTime timeOpen;
    @JsonProperty("time_close")
    private ZonedDateTime timeClose;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Long volume;
    @JsonProperty("market_cap")
    private Long marketCap;
}
