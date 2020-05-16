package com.cryptowallet.tronModels;

import lombok.Data;

@Data
public class AccountInfo {
    private boolean success;
    private Meta meta;
    private Datum[] data;
}
