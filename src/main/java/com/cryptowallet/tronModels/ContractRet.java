package com.cryptowallet.tronModels;

import java.io.IOException;
import java.io.Serializable;

public enum ContractRet implements Serializable {
    SUCCESS;

    public String toValue() {
        switch (this) {
            case SUCCESS: return "SUCCESS";
        }
        return null;
    }

    public static ContractRet forValue(String value) throws IOException {
        if (value.equals("SUCCESS")) return SUCCESS;
        throw new IOException("Cannot deserialize ContractRet");
    }
}
