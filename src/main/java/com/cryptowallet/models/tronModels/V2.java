package com.cryptowallet.models.tronModels;

import lombok.Data;

import java.io.Serializable;

@Data
public class V2 implements Serializable {
    private String key;
    private long value;
}
