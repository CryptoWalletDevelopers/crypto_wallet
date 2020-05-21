package com.cryptowallet.tronModels;

import lombok.Data;

import java.io.Serializable;

@Data
public class Meta implements Serializable {
    private long at;
    private long pageSize;
}
