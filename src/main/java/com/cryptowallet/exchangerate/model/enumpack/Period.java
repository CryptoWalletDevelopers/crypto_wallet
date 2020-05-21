package com.cryptowallet.exchangerate.model.enumpack;

public enum Period {
    TODAY(24L), WEEK(1L), MONTH(1L), MONTH_3(3L), MONTH_6(6L),
    YEAR(1L), YEAR_2(2L), YEAR_3(3L);

    private long value;

    Period(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Period{" +
                "value=" + value +
                '}';
    }
}
