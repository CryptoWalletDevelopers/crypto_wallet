package com.cryptowallet;

import com.cryptowallet.API.blockchain.TronAPI;
import com.cryptowallet.models.tronModels.Account;
import com.cryptowallet.models.tronModels.Block;
import com.cryptowallet.models.tronModels.Result;
import com.cryptowallet.models.tronModels.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TronApiTest {
    @Autowired
    private TronAPI tronApi;

    @Test
    public void getBlockByNumTest() {
        Block block = tronApi.getBlockByNum(34);
        Assert.assertTrue(block.getBlockID().equals("0000000000000022e8431f7f9fdc7ec220fe9a11021adcf86d962cf0dedc4c8c"));
    }

    @Test
    public void getBlockInfoByIdTest(){
        Block block = tronApi.getBlockInfoById("00000000000000c82a54a3bbdc956e1ddebc903f29b8daf28505b56f55a3f87d");
        Assert.assertTrue(block.getBlockHeader().getRawData().getNumber()==200);
    }
    @Test
    public void getTransactionInfoByIdTest(){
        Transaction transaction = tronApi.getTransactionInfoById("d0807adb3c5412aa150787b944c96ee898c997debdc27e2f6a643c771edb5933");
        Assert.assertTrue(transaction.getFee()==2790);
    }

    @Test
    public void createTransactionTest(){
        Transaction transaction= tronApi.createTransaction("41e9d79cc47518930bc322d9bf7cddd260a0260a8d","41608F8DA72479EDC7DD921E4C30BB7E7CDDBE722E",12);
        Assert.assertTrue(transaction.getRawData().getContract().length==1);
    }

    @Test
    public void accountInfoByAddressTest(){
      Account account = tronApi.accountInfoByAddress("41E552F6487585C2B58BC2C9BB4492BC1F17132CD0");
      Assert.assertTrue(account.getAccountname().equals("636363797979636363"));
    }

    @Test
    public void broadcastTransactionHexTest(){
        Result result = tronApi.broadcastTransactionHex("0A8A010A0202DB2208C89D4811359A28004098A4E0A6B52D5A730802126F0A32747970652E676F6F676C65617069732E636F6D2F70726F746F636F6C2E5472616E736665724173736574436F6E747261637412390A07313030303030311215415A523B449890854C8FC460AB602DF9F31FE4293F1A15416B0580DA195542DDABE288FEC436C7D5AF769D24206412418BF3F2E492ED443607910EA9EF0A7EF79728DAAAAC0EE2BA6CB87DA38366DF9AC4ADE54B2912C1DEB0EE6666B86A07A6C7DF68F1F9DA171EEE6A370B3CA9CBBB00");
        Assert.assertTrue(result.isResult()==false);
    }
}


