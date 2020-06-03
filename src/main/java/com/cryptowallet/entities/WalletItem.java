package com.cryptowallet.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class WalletItem {
    private String address;
    private String currency;
    private Double balance;

    public WalletItem(String address, String currency, Double balance) {
        this.address = address;
        this.currency = currency;
        this.balance = balance;
    }
}
