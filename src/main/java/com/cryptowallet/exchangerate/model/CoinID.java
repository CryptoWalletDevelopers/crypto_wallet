package com.cryptowallet.exchangerate.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 * ID валют для запросов
 */
public class CoinID {
    private String id;
    private Integer rank;
}
