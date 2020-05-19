package com.cryptowallet.entities.dto.cryptoCoinDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DataCryptoExchangeResponse{

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "data")
    private List<DataDTO> dataDTO;
}
