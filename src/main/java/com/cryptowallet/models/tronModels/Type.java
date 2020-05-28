package com.cryptowallet.models.tronModels;

import java.io.IOException;

public enum Type {
    TRANSFER_ASSET_CONTRACT,
    TRANSFER_CONTRACT,
    TRIGGER_SMART_CONTRACT,
    VOTE_WITNESS_CONTRACT;

    public String toValue() {
        switch (this) {
            case TRANSFER_ASSET_CONTRACT: return "TransferAssetContract";
            case TRANSFER_CONTRACT: return "TransferContract";
            case TRIGGER_SMART_CONTRACT: return "TriggerSmartContract";
            case VOTE_WITNESS_CONTRACT: return "VoteWitnessContract";
        }
        return null;
    }

    public static Type forValue(String value) throws IOException {
        if (value.equals("TransferAssetContract")) return TRANSFER_ASSET_CONTRACT;
        if (value.equals("TransferContract")) return TRANSFER_CONTRACT;
        if (value.equals("TriggerSmartContract")) return TRIGGER_SMART_CONTRACT;
        if (value.equals("VoteWitnessContract")) return VOTE_WITNESS_CONTRACT;
        throw new IOException("Cannot deserialize Type");
    }
}