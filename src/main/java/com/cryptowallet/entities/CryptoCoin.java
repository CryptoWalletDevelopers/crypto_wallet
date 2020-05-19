package com.cryptowallet.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
public class CryptoCoin {

    private String name;
    private String symbol;
    private BigDecimal price;
    private BigDecimal percentChang1h;
    private BigDecimal percentChang24h;
    private BigDecimal percentChang7d;
}
