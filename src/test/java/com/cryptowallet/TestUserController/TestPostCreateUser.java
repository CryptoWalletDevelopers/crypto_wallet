package com.cryptowallet.TestUserController;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.MailServiceDefault;
import com.cryptowallet.services.RoleServiceImpl;
import com.cryptowallet.services.SecurityUserService;
import com.cryptowallet.services.facades.UserServiceFacadeImpl;

import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

import com.cryptowallet.utils.ValidateInputData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-user-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-user-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class TestPostCreateUser {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private RoleServiceImpl roleServiceImpl;
    @Autowired
    private UserServiceFacadeImpl userServiceFacadeImpl;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private SecurityUserService securityUserService;

    @MockBean
    private HttpServletRequest httpServletRequest;
    @MockBean
    private MailServiceDefault mailServiceDefault;

    private User user;

    @Before
    public void initTest () {
        user = new User ();
        user.setLogin("test");
        user.setEmail("test@localhost.com");
        user.setPassword("1234567");
        user.setRole(roleServiceImpl.getUserRole());
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void testCreateUser () throws Exception {
        mvc.perform(post("/create_user")
                .flashAttr("user", user)
                .with(csrf()))
                .andExpect(status().isFound())
                .andDo(print())
                .andExpect(model().size(0))
                .andExpect(redirectedUrl("/"))
                .andExpect(authenticated());
        verify(mailServiceDefault, times(1)).sendActiveCodeToMail(user);
    }

    @MockBean
    ValidateInputData validateInputData;

    @Test
    public void testCreateUserValidator () throws Exception {
        user.setEmail("incorrect.mail@test");
        mvc.perform(post("/create_user")
                .flashAttr("user", user)
                .with(csrf()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(2));    // ловим ошибку { email format error , login is exists }
        verify(mailServiceDefault, times(0)).sendActiveCodeToMail(user);
    }
}
