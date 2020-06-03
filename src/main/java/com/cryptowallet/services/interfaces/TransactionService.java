package com.cryptowallet.services.interfaces;

import com.cryptowallet.models.tronModels.Result;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public interface TransactionService {
     Result TransferTransaction(@NonNull String address_to, @NonNull String address_from, @NonNull int amount) throws InvalidProtocolBufferException;
}
