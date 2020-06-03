package com.cryptowallet.models.exchangerateModels.enumpack;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum Interval {
    M5("5m"), M10("10m"), M15("15m"), M30("30m"), M45("45m"),
    H1("1h"), H2("2h"), H3("3h"), H6("6h"), H12("12h"), H24("24h"),
    D1("1d"), D7("7d"), D14("14d"), D30("30d"), D90("90d"), D365("365d");

    private String value;
}
