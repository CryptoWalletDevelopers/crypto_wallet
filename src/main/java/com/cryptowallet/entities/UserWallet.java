package com.cryptowallet.entities;

import lombok.Data;
import java.util.ArrayList;

@Data
public class UserWallet {
    private ArrayList<WalletItem> walletItems;

    public UserWallet(ArrayList<WalletItem> walletItems) {
        this.walletItems = walletItems;
    }
}
