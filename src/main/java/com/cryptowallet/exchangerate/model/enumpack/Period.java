package com.cryptowallet.exchangerate.model.enumpack;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum Period {
    TODAY(24L), WEEK(1L), MONTH(1L), MONTH_3(3L), MONTH_6(6L),
    YEAR(1L), YEAR_2(2L), YEAR_3(3L);

    private long value;
}
