package com.cryptowallet.models.tronModels;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountResource implements Serializable {
    private long latestConsumeTimeForEnergy;
}
