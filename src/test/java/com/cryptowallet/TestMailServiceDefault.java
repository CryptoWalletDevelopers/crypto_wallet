package com.cryptowallet;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.MailServiceDefault;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetupTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.Message;
import javax.mail.MessagingException;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class TestMailServiceDefault {
    private final String token = "TEST-TOKEN-1234567890";
    private final String loginUserTo = "test";
    private final String ACTIVE_TITLE = "Activation code";
    private final String RESTORE_TITLE = "Restore Password";

    @Value("${mail.username}")
    private String userMailFrom;

    @Value("${mail.password}")
    private String passwordFrom;

    @Value("${mail.to.username}")
    private String userMailTo;

    @Autowired
    private MailServiceDefault mailServiceDefault;

    private GreenMail greenMail;
    private User user;

    @Before
    public void testMailServiceInit () {
        greenMail = new GreenMail(ServerSetupTest.SMTP);
        greenMail.start();
        user = new User ();
        greenMail.setUser(userMailFrom, userMailFrom, passwordFrom);
        greenMail.setUser(userMailTo, userMailTo);
        user.setLogin(loginUserTo);
        user.setEmail(userMailTo);
        user.setToken(token);
    }

    @Test
    public void testMailServiceActivationCode () throws MessagingException {
        mailServiceDefault.sendActiveCodeToMail(user);
        checkMail(ACTIVE_TITLE);
    }

    @Test
    public void testMailServiceRestorePassword () throws MessagingException {
        mailServiceDefault.sendRestorePasswordMail(user);
        checkMail(RESTORE_TITLE);
    }

    private void checkMail (String tittle) throws MessagingException {
        Message [] messages = greenMail.getReceivedMessages();
        assertEquals(1, messages.length);
        assertEquals(tittle, messages[0].getSubject());
    }

    @After
    public void stopGreenMailServer () {
       greenMail.stop();
    }
}
