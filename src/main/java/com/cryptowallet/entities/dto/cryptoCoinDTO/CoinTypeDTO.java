package com.cryptowallet.entities.dto.cryptoCoinDTO;

import com.cryptowallet.entities.dto.BasicJson;
import com.cryptowallet.entities.dto.cryptoCoinDTO.QuoteDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CoinTypeDTO implements BasicJson, Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty
    private Integer id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String symbol;
    @JsonProperty
    private String slug;
    @JsonProperty(value = "quote")
    private QuoteDTO quoteDTO;
}
