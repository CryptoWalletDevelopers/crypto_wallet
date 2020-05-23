package com.cryptowallet.services.facades;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.MailServiceDefault;
import com.cryptowallet.services.RoleServiceDefault;
import com.cryptowallet.services.UserServiceDefault;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@Log4j2
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-user-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-user-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class UserServiceDefaultFacadeTest {
    @MockBean
    private MailServiceDefault mailServiceDefault;
    @MockBean
    private HttpServletRequest request;

    @Autowired
    private UserServiceFacadeImpl facade;
    @Autowired
    private RoleServiceDefault roleServiceDefault;
    @Autowired
    private UserServiceDefault userServiceDefault;

    @Test
    void isUserExist() {
        Assert.assertTrue(facade.isUserExist("seConD"));            // login
        Assert.assertTrue(facade.isUserExist("secOnd@maiL.Ru"));    // email

        Assert.assertFalse(facade.isUserExist("unknown"));          // unknown or incorrect - not into db
        Assert.assertFalse(facade.isUserExist("PWAPLZvFTXf02"));    // token
    }

    @Test
    void findUser() {
        Assert.assertEquals("second", facade.findUser("SeCoNd").getLogin());                  // login
        Assert.assertEquals("second@mail.ru", facade.findUser("second@mail.ru").getEmail());  // email

        Assert.assertNull("PWAPLZvFTXf01", facade.findUser("PWAPLZvFTXf02"));                 // token
        Assert.assertNull("second",facade.findByToken("unknown"));                          // unknown or incorrect - not into db
    }

    @Test
    void findByLogin() {
        Assert.assertEquals("second", facade.findByLogin("seConD").getLogin());         // login

        Assert.assertNull(facade.findByLogin("secOnd@maiL.Ru"));                                // email
        Assert.assertNull(facade.findByLogin("unknown"));                                       // unknown or incorrect - not into db
        Assert.assertNull(facade.findByLogin("PWAPLZvFTXf02"));                                 // token
    }

    @Test
    void findByToken() {
        Assert.assertEquals("second",facade.findByToken("PWAPLZvFTXf02").getLogin());   // token

        Assert.assertNull("second",facade.findByToken("pWAPLZvFTXf02"));                // bad token (another case)
        Assert.assertNull("second", facade.findByToken("seConD"));                      // login
        Assert.assertNull("second",facade.findByToken("secOnd@maiL.Ru"));               // email
        Assert.assertNull("second",facade.findByToken("unknown"));                      // unknown or incorrect - not into db
    }

    @Test
    void restorePassword() {
        Assert.assertEquals("PWAPLZvFTXf01", facade.findUser("first").getToken());
        facade.restorePassword("first");
        Assert.assertNotEquals("PWAPLZvFTXf01", facade.findUser("first").getToken());
        Assert.assertNotEquals("", facade.findUser("first").getToken());
        Assert.assertNotNull(facade.findUser("first").getToken());
    }

    @Test
    void sendActiveCodeToMail() {
        User user = facade.findByLogin("second");
        Assert.assertEquals("PWAPLZvFTXf02", user.getToken());

        user.setApproved(true);
        facade.sendActiveCodeToMail(user);
        Assert.assertEquals("PWAPLZvFTXf02", user.getToken());

        user.setApproved(false);
        facade.sendActiveCodeToMail(user);
        Assert.assertNotEquals("PWAPLZvFTXf02", user.getToken());
        Assert.assertNotEquals("", user.getToken());
        Assert.assertNotNull(user.getToken());

        verify(mailServiceDefault, (times(1))).sendActiveCodeToMail(user);
    }

    @Test
    void createNewUser() {
        User user = createTestUser("TestUser");

        Assert.assertNull(facade.findUser(user.getLogin()));

        facade.createNewUser(user, "test-password", request);
        Assert.assertEquals("testuser", facade.findUser(user.getLogin()).getLogin());

        verify(mailServiceDefault, (times(1))).sendActiveCodeToMail(user);
    }

    @Test
    void activateUser() {
        User user = createTestUser("activate-user");
        facade.createNewUser(user, "test-password", request);

        Assert.assertFalse(facade.findUser("activate-user").isApproved());
        Assert.assertNotNull(facade.findUser("activate-user").getToken());
        Assert.assertNotNull(facade.findUser("activate-user").getDateExpired());

        facade.activateUser(user);
        Assert.assertTrue(facade.findUser("activate-user").isApproved());
        Assert.assertNull(facade.findUser("activate-user").getToken());
        Assert.assertNull(facade.findUser("activate-user").getDateExpired());

        verify(mailServiceDefault, (times(1))).sendActiveCodeToMail(user);
    }

    @Test
    void updatePassword() {
        User user = facade.findUser("first");
        user.setApproved(false);
        user.setDateExpired(new Date());
        userServiceDefault.saveUser(user);

        Assert.assertEquals("123", facade.findUser("first").getPassword());
        Assert.assertFalse(facade.findUser("first").isApproved());
        Assert.assertNotNull(facade.findUser("first").getToken());
        Assert.assertNotNull(facade.findUser("first").getDateExpired());

        facade.updatePassword(user, "333");
        Assert.assertNotEquals("123", facade.findUser("first").getPassword());
        Assert.assertTrue(facade.findUser("first").isApproved());
        Assert.assertNull(facade.findUser("first").getToken());
        Assert.assertNull(facade.findUser("first").getDateExpired());
    }

    @Test
    void clearFields() {
        User user = createTestUser("clear-fld-user");

        Assert.assertEquals("clear-fld-user", user.getLogin());
        Assert.assertEquals("clear-fld-user_mail@test.test", user.getEmail());
        Assert.assertEquals("test-password", user.getPassword());

        facade.clearFields(user);

        Assert.assertEquals("", user.getLogin());
        Assert.assertEquals("", user.getEmail());
        Assert.assertEquals("", user.getPassword());
    }

    //    ----------------- Create test user -----------------

    private User createTestUser(String name) {
        User user = new User();
        user.setPassword("test-password");
        user.setRole(roleServiceDefault.getUserRole());
        user.setEmail(name + "_mail@test.test");
        user.setLogin(name);
        return user;
    }
}