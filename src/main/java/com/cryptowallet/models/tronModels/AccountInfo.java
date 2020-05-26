package com.cryptowallet.models.tronModels;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountInfo implements Serializable {
    private boolean success;
    private Meta meta;
    private Datum[] data;
}
