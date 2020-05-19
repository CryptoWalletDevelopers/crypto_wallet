package com.cryptowallet.entities.dto.cryptoCoinDTO;

import com.cryptowallet.entities.dto.BasicJson;
import com.cryptowallet.entities.dto.monetaryUnit.USD;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuoteDTO implements BasicJson, Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "USD")
    private USD usd;
}
