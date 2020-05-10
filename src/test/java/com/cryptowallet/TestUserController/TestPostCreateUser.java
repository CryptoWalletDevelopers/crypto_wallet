package com.cryptowallet.TestUserController;

import com.cryptowallet.entities.Role;
import com.cryptowallet.entities.User;
import com.cryptowallet.services.RoleService;
import com.cryptowallet.services.SecurityUserService;
import com.cryptowallet.services.facades.UserServiceFacade;
import com.cryptowallet.utils.ValidateInputData;

import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//---Тесты не рабочие

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestPostCreateUser {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private RoleService roleService;
    @MockBean
    private UserServiceFacade userServiceFacade;
    @Autowired
    private WebApplicationContext context;
    @MockBean
    private HttpServletRequest httpServletRequest;
    @MockBean
    private SecurityUserService securityUserService;

    private User user;

    @Before
    public void initTest () {
        user = new User ();
        user.setLogin("test");
        user.setEmail("test@localhost.com");
        user.setPassword("1234567");
        user.setRole(roleService.getUserRole());
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void testCreateUser () throws Exception {
        //Не знаю как проверить автологирование request.login(user.getLogin(), password);
        mvc.perform(post("/create_user")
                .flashAttr("user", user)
                .with(csrf()))
                .andExpect(status().isFound())
                .andDo(print())
                .andExpect(redirectedUrl("/"))
                .andExpect(authenticated());
        verify(userServiceFacade, times(1)).createNewUser(user);
    }

    @Test
    public void testCreateUserValidator () throws Exception {
        user.setPassword("123");
        mvc.perform(post("/create_user")
                .flashAttr("user", user)
                .with(csrf()))
                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(model().size(1));
               // .andExpect(model().attribute("not_valid", error));
        verify(userServiceFacade, times(0)).createNewUser(user);
    }
}
