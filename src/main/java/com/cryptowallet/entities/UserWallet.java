package com.cryptowallet.entities;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
@Component
public class UserWallet {
    private ArrayList<WalletItem> walletItems;
}
