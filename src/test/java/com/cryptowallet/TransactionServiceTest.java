package com.cryptowallet;

import com.cryptowallet.services.implementations.TronTransactionServiceImpl;
import com.cryptowallet.models.tronModels.Transaction;
import com.cryptowallet.wallets.TronWallet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WalletApplication.class)
@WebAppConfiguration
@TestPropertySource("/application.properties")
public class TransactionServiceTest {
    @Autowired
    TronTransactionServiceImpl tronTransactionService;
    @Autowired
    TronWallet tronWallet;

    @Test()
    public void TransferTransactionTest() throws InvalidProtocolBufferException {
        Assert.assertTrue((tronTransactionService.TransferTransaction("TKoKKzqr4TkPgoGmAxH94f3fZKKe9eUPCe","TKmdnkRurAxJyd1VeE8BLGmY5oaH2UBfLn",10000).isResult()==true));
    }

    @Test
    public void TransactionSign() throws Exception {
        String obj = "{\"visible\":false,\"txID\":\"b0a4f722609ee92e61c92e688ccb3999ae34a98a27af6c38a98f8028c861751f\",\"raw_data\":{\"contract\":[{\"parameter\":{\"value\":{\"amount\":100,\"owner_address\":\"416b80f544fb65a82cdfc90c0a61c44aebd38e9c73\",\"to_address\":\"416bd2611cd6c18e35cc22bfe15492a5ce57ac0f1a\"},\"type_url\":\"type.googleapis.com/protocol.TransferContract\"},\"type\":\"TransferContract\"}],\"ref_block_bytes\":\"314f\",\"ref_block_hash\":\"2a7caebe27597f72\",\"expiration\":1590071643000,\"timestamp\":1590071585606},\"raw_data_hex\":\"0a02314f22082a7caebe27597f7240f8969fbda32e5a65080112610a2d747970652e676f6f676c65617069732e636f6d2f70726f746f636f6c2e5472616e73666572436f6e747261637412300a15416b80f544fb65a82cdfc90c0a61c44aebd38e9c731215416bd2611cd6c18e35cc22bfe15492a5ce57ac0f1a186470c6d69bbda32e\"}";
        ObjectMapper mapper = new ObjectMapper();
        Transaction transaction = mapper.readValue(obj, Transaction.class);
        Transaction signedTransaction = tronWallet.signTransaction2Byte(transaction,tronWallet.getPrivateKeyFromAddress("TKmdnkRurAxJyd1VeE8BLGmY5oaH2UBfLn"));
        String signedTransactionStr = "";
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            signedTransactionStr = ow.writeValueAsString(signedTransaction);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        signedTransactionStr = signedTransactionStr.replaceAll("\\s+","");
        signedTransactionStr = signedTransactionStr.replaceAll("\\n",",");
        System.out.println(signedTransactionStr);
        System.out.println(TronTransactionServiceImpl.stringToHex(signedTransactionStr));
        Assert.assertTrue(signedTransaction.getSignature()[0].toString().equals("954cc17bc4fecfe1e1e3fbf4fc9085df31a8df2dd2a4709685d820509f1eadcc6da017995a00f545c994de498863e8fdc83386d58a9e1bd944078c3b4e8683fe00"));
    }
}
