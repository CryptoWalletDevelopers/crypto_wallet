package com.cryptowallet.services.facades;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.MailService;
import com.cryptowallet.services.RoleService;
import com.cryptowallet.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;


@Log4j2
@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-user-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-user-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class UserServiceFacadeTest {
    @MockBean
    private MailService mailService;

    @Autowired
    private UserServiceFacade facade;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

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
    }

    @Test
    void createNewUser() {
        User user = createTestUser("TestUser");

        Assert.assertNull(facade.findUser(user.getLogin()));

        facade.createNewUser(user);
        Assert.assertEquals("testuser", facade.findUser(user.getLogin()).getLogin());
    }

    @Test
    void activateUser() {
        User user = createTestUser("activate-user");
        facade.createNewUser(user);

        Assert.assertFalse(facade.findUser("activate-user").isApproved());
        Assert.assertNotNull(facade.findUser("activate-user").getToken());
        Assert.assertNotNull(facade.findUser("activate-user").getDate_exp());

        facade.activateUser(user);
        Assert.assertTrue(facade.findUser("activate-user").isApproved());
        Assert.assertNull(facade.findUser("activate-user").getToken());
        Assert.assertNull(facade.findUser("activate-user").getDate_exp());
    }

    @Test
    void updatePassword() {
        User user = facade.findUser("first");
        user.setApproved(false);
        user.setDate_exp(new Date());
        userService.saveUser(user);

        Assert.assertEquals("123", facade.findUser("first").getPassword());
        Assert.assertFalse(facade.findUser("first").isApproved());
        Assert.assertNotNull(facade.findUser("first").getToken());
        Assert.assertNotNull(facade.findUser("first").getDate_exp());

        facade.updatePassword(user, "333");
        Assert.assertNotEquals("123", facade.findUser("first").getPassword());
        Assert.assertTrue(facade.findUser("first").isApproved());
        Assert.assertNull(facade.findUser("first").getToken());
        Assert.assertNull(facade.findUser("first").getDate_exp());
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
        user.setRole(roleService.getUserRole());
        user.setEmail(name + "_mail@test.test");
        user.setLogin(name);
        return user;
    }
}