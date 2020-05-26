package com.cryptowallet.services.interfaces;

import com.cryptowallet.entities.User;
import org.springframework.lang.NonNull;

public interface MailService {

    void sendActiveCodeToMail(@NonNull User user);

    void sendRestorePasswordMail(@NonNull User user);

    void sendMessageToMail(@NonNull User user, String messageType, String title);
}
