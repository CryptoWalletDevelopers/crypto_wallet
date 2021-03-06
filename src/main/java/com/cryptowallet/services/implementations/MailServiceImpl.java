package com.cryptowallet.services.implementations;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.interfaces.MailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Log4j2
@Service
public class MailServiceImpl implements MailService {
    @Value("${wallet.url}")
    private String url;

    private final String ACTIVE_MESSAGE = "Welcome to Crypto Wallet. To activate your account please, visit next link: %s/activate/";
    private final String RESTORE_MESSAGE = "visit next link: %s/restore/";
    private final String ACTIVE_TITLE = "Activation code";
    private final String RESTORE_TITLE = "Restore Password";
    private JavaMailSender sender;

    @Autowired
    public void setSender(JavaMailSender sender) {
        this.sender = sender;
    }

    @Override
    public void sendActiveCodeToMail(User user){
        sendMessageToMail(user, ACTIVE_MESSAGE, ACTIVE_TITLE);
    }

    @Override
    public void sendRestorePasswordMail(User user) {
        sendMessageToMail(user, RESTORE_MESSAGE, RESTORE_TITLE);
    }

    @Override
    public void sendMessageToMail(User user, String messageType, String title) {
        try {
            String message = String.format(
                    "Hello, %s! \n" + messageType + "%s",
                    user.getLogin(), url, user.getToken()
            );
            sendMail(user.getEmail(), title, message);
        } catch (MessagingException e){
            log.warn("Unable to create mail message for user: " + user.getLogin());
        } catch (MailException e){
            log.warn("Unable to send mail message for user: " + user.getLogin());
        }
    }

    public void sendMail(String email, String subject, String text) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setTo(email);
        helper.setText(text, true);
        helper.setSubject(subject);
        sender.send(message);
    }
}