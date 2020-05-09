package com.cryptowallet.TestUserController;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.facades.UserServiceFacade;
import com.cryptowallet.utils.ValidateInputData;

import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpServletRequest;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestMethodCreateUser {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private UserServiceFacade userServiceFacade;
    @MockBean
    private ValidateInputData validError;
    @MockBean
    private HttpServletRequest httpServletRequest;
    private User user;
    private Map<String,String> error;

    @Before
    public void initTest () {
        user = new User ();
        user.setLogin("test");
        user.setEmail("test@localhost.com");
        user.setPassword("1234567");
        error = new HashMap<>();
        error.put("not_valid","Incorrect input data");
//        mvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();
    }

    @Test
    public void testCreateUser () throws Exception {
        given(validError.isEmpty()).willReturn(true);
        //Не знаю как проверить автологирование request.login(user.getLogin(), password);
        mvc.perform(post("/create_user")
                .flashAttr("user", user)
                .with(csrf()))
                .andExpect(status().isFound())
                .andDo(print())
                .andExpect(redirectedUrl("/"));
        verify(userServiceFacade, times(1)).createNewUser(user);
    }

    @Test
    public void testCreateUserValidator () throws Exception {
        given(validError.isEmpty()).willReturn(false);
        given(validError.getValidationErrors()).willReturn(error);
        mvc.perform(post("/create_user")
                .flashAttr("user", user)
                .with(csrf()))
                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(model().size(1))
                .andExpect(model().attribute("not_valid", error))
                .andExpect(redirectedUrl("/registration"));
        verify(userServiceFacade, times(0)).createNewUser(user);
    }
}
