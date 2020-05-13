package com.cryptowallet.TestUserController;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.facades.UserServiceFacadeImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Date;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class TestGetRestoreUser {
    private final long EXPIRED_TIME = 60 * 60 * 1000 * 3;
    private final String token = "TEST-TOKEN-1234567890";
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserServiceFacadeImpl userServiceFacadeImpl;
    private User user;

    @Before
    public void initTest () {
        user = new User ();
        user.setLogin("test");
        user.setToken(token);
        user.setDateExpired(new Date());
    }

    @Test
    public void testGetRestoreUserValid () throws Exception {
        given(userServiceFacadeImpl.findByToken(token)).willReturn(user);
        mvc.perform(get("/restore/"+token).param("code", token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(model().attribute("email", user.getEmail()))
                .andExpect(xpath("/html/body/form").nodeCount(1))
                .andExpect(content().string(containsString("Input new password for yor account")));
    }

    @Test
    public void testGetRestoreUserTimeOver () throws Exception {
        long date = new Date().getTime() - EXPIRED_TIME;
        Date userDate = new Date();
        userDate.setTime(date);
        user.setDateExpired(userDate);
        given(userServiceFacadeImpl.findByToken(token)).willReturn(user);
        mvc.perform(get("/restore/"+token).param("code", token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(model().attribute("not_valid", "Your account is not verified!"))
                .andExpect(content().string(containsString("Input yor email to restore password")));
    }

    @Test
    public void testGetRestoreUserDontExist () throws Exception {
        given(userServiceFacadeImpl.findByToken(token)).willReturn(null);
        mvc.perform(get("/restore/"+token).param("code", token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(model().attribute("activeMessage", "Your account is not verified!"));
    }

}
