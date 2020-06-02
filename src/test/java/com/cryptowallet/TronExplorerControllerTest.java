package com.cryptowallet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WalletApplication.class)
@WebAppConfiguration
@TestPropertySource("/application.properties")
public class TronExplorerControllerTest {
    @Autowired
    private WebApplicationContext webContext;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
    }

    @Test
    public void explorePage() throws Exception {
            mockMvc.perform(get("http://localhost:8189/explorer"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void getBlockInfo() throws Exception {
        mockMvc.perform(post("http://localhost:8189/explorer/findBlock").param("blockHash","00000000000000c82a54a3bbdc956e1ddebc903f29b8daf28505b56f55a3f87d"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getTransactionInfo() throws Exception {
        mockMvc.perform(post("http://localhost:8189/explorer/findTransacton").param("transactionId","d0807adb3c5412aa150787b944c96ee898c997debdc27e2f6a643c771edb5933"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
