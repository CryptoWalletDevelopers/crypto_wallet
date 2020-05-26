package com.cryptowallet.tronModels;

import java.io.IOException;

public enum TypeURL {
    TYPE_GOOGLEAPIS_COM_PROTOCOL_TRANSFER_ASSET_CONTRACT,
    TYPE_GOOGLEAPIS_COM_PROTOCOL_TRANSFER_CONTRACT,
    TYPE_GOOGLEAPIS_COM_PROTOCOL_TRIGGER_SMART_CONTRACT,
    TYPE_GOOGLEAPIS_COM_PROTOCOL_VOTE_WITNESS_CONTRACT;

    public String toValue() {
        switch (this) {
            case TYPE_GOOGLEAPIS_COM_PROTOCOL_TRANSFER_ASSET_CONTRACT: return "type.googleapis.com/protocol.TransferAssetContract";
            case TYPE_GOOGLEAPIS_COM_PROTOCOL_TRANSFER_CONTRACT: return "type.googleapis.com/protocol.TransferContract";
            case TYPE_GOOGLEAPIS_COM_PROTOCOL_TRIGGER_SMART_CONTRACT: return "type.googleapis.com/protocol.TriggerSmartContract";
            case TYPE_GOOGLEAPIS_COM_PROTOCOL_VOTE_WITNESS_CONTRACT: return "type.googleapis.com/protocol.VoteWitnessContract";
        }
        return null;
    }

    public static TypeURL forValue(String value) throws IOException {
        if (value.equals("type.googleapis.com/protocol.TransferAssetContract")) return TYPE_GOOGLEAPIS_COM_PROTOCOL_TRANSFER_ASSET_CONTRACT;
        if (value.equals("type.googleapis.com/protocol.TransferContract")) return TYPE_GOOGLEAPIS_COM_PROTOCOL_TRANSFER_CONTRACT;
        if (value.equals("type.googleapis.com/protocol.TriggerSmartContract")) return TYPE_GOOGLEAPIS_COM_PROTOCOL_TRIGGER_SMART_CONTRACT;
        if (value.equals("type.googleapis.com/protocol.VoteWitnessContract")) return TYPE_GOOGLEAPIS_COM_PROTOCOL_VOTE_WITNESS_CONTRACT;
        throw new IOException("Cannot deserialize TypeURL");
    }

}