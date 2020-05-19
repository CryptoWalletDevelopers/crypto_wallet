package com.cryptowallet.exchangerate.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({ "market_cap_usd", "volume_24h_usd", "bitcoin_dominance_percentage", "cryptocurrencies_number",
//		"last_updated" })
public class GlobalInfo {

	@JsonProperty("market_cap_usd")
	private Double marketCapUsd;
	@JsonProperty("volume_24h_usd")
	private Double volume24hUsd;
	@JsonProperty("bitcoin_dominance_percentage")
	private Double bitcoinDominancePercentage;
	@JsonProperty("cryptocurrencies_number")
	private Integer cryptocurrenciesNumber;
	@JsonProperty("last_updated")
	private Integer lastUpdated;
	@JsonProperty("market_cap_ath_value")
	private Double marketCapAthValue;
	@JsonProperty("market_cap_ath_date")
	private ZonedDateTime marketCapAthDate;
	@JsonProperty("volume_24h_ath_value")
	private Double volume24hAthValue;
	@JsonProperty("volume_24h_ath_date")
	private ZonedDateTime volume24hAthDate;
	@JsonProperty("market_cap_change_24h")
	private Double marketCapChange24h;
	@JsonProperty("volume_24h_change_24h")
	private Double volume24hChange24h;

}
