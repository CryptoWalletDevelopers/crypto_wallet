package com.cryptowallet.models.tronModels;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private boolean result;
    private String code;
    private String txid;
    private String message;
    private String transaction;
    private String error;
}
