package com.cryptowallet.models.tronModels;

import lombok.Data;

import java.io.Serializable;

@Data
public class Asset implements Serializable {
    private String key;
    private long value;
}
