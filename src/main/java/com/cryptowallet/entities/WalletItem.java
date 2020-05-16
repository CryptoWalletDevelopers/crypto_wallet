package com.cryptowallet.entities;

import lombok.Data;

@Data
public class WalletItem {
    private String address;
    private Integer currency;
    private Long balance;

    public WalletItem(String address, Integer currency, Long balance) {
        this.address = address;
        this.currency = currency;
        this.balance = balance;
    }
}
