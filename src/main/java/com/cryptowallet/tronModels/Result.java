package com.cryptowallet.tronModels;

import lombok.Data;

@Data
public class Result {
    private boolean result;
    private String code;
    private String txid;
    private String message;
    private String transaction;
}
