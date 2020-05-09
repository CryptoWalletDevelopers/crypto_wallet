package com.cryptowallet.TestUserController;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.facades.UserServiceFacade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Date;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestGetActivateUser {
    private final long EXPIRED_TIME = 60 * 60 * 1000 * 3;
    private final String token = "TEST-TOKEN-1234567890";
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserServiceFacade userServiceFacade;
    private User user;

    @Before
    public void initTest () {
        user = new User ();
        user.setLogin("test");
        user.setToken(token);
        user.setDate_exp(new Date());
    }

    @Test
    public void testGetActivateUserValid () throws Exception {
        given(userServiceFacade.findByToken(token)).willReturn(user);
        mvc.perform(get("/activate/"+token).param("code", token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(model().attribute("activeMessage", "Your account is verified!"));
        verify(userServiceFacade, times(1)).activateUser(user);
    }

    @Test
    public void testGetActivateUserTimeOver () throws Exception {
        long date = new Date().getTime() - EXPIRED_TIME;
        Date userDate = new Date();
        userDate.setTime(date);
        user.setDate_exp(userDate);
        given(userServiceFacade.findByToken(token)).willReturn(user);
        mvc.perform(get("/activate/"+token).param("code", token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(model().attribute("activeMessage", "Your token is expired! We have sent you an email with a new token."));
        verify(userServiceFacade, times(1)).sendActiveCodeToMail(user);
    }

    @Test
    public void testGetActivateUserDontExist () throws Exception {
        given(userServiceFacade.findByToken(token)).willReturn(null);
        mvc.perform(get("/activate/"+token).param("code", token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(model().attribute("activeMessage", "Your account is not verified!"));
    }
}
