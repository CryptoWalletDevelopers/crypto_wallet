package com.cryptowallet.models.exchangerateModels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 * timestamp - временная отметка в формате RFC3999 (ISO-8601), пример JSON 2018-09-01T00:00:00Z
 * volume24h - количество единиц актива обмененых за 24 ч
 * marketCap - рыночная капитализация на момент времени timestamp
 * price - цена на момент времени timestamp в USD
 */
public class Ticker {
	private ZonedDateTime timestamp;
	private Double price;
	@JsonProperty("volume_24h")
	private Long volume24h;
	@JsonProperty("market_cap")
	private Long marketCap;
}
