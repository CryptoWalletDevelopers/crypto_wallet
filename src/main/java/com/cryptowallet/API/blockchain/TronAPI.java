package com.cryptowallet.API.blockchain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cryptowallet.models.tronModels.*;
import com.cryptowallet.wallets.TronWallet;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import top.jfunc.json.JsonObject;
import top.jfunc.json.impl.JSONArray;
import javax.annotation.PostConstruct;
import java.util.*;

@EnableWebMvc
@Component
public class TronAPI extends APIClient {
    private final RestTemplate restTemplate;
    private TronWallet tronWallet;

    @Autowired
    public TronAPI(RestTemplateBuilder restTemplateBuilder, TronWallet tronWallet){
        this.restTemplate = restTemplateBuilder.build();
        this.tronWallet = tronWallet;
    }

    @PostConstruct
    public void init(){
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
    }

    @Override
    public Block getNowBlock() {
        String url = "https://api.trongrid.io/wallet/getnowblock";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String empty = new String();
        HttpEntity<String> entity = new HttpEntity<>(empty,headers);
        ResponseEntity<Block> response = this.restTemplate.postForEntity(url, entity, Block.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    @Override
    public Block getBlockInfoById(String id) {
        String url = "https://api.trongrid.io/wallet/getblockbyid";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, Object> request = new HashMap<>();
        request.put("value", id);
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(request,headers);
        ResponseEntity<Block> response = this.restTemplate.postForEntity(url, entity, Block.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    @Override
    public Block getBlockByNum(int number) {
        String url = "https://api.trongrid.io/wallet/getblockbynum";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, Object> request = new HashMap<>();
        request.put("num", number);
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(request,headers);
        ResponseEntity<Block> response = this.restTemplate.postForEntity(url, entity, Block.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    @Override
    public Transaction getTransactionInfoById(String id) {
        String url = "https://api.trongrid.io/wallet/gettransactioninfobyid";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, Object> request = new HashMap<>();
        request.put("value", id);
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(request,headers);
        ResponseEntity<Transaction> response = this.restTemplate.postForEntity(url,entity,Transaction.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    @Override
    public Transaction createTransaction(String to_address, String owner_address, int amount) {
        String url = "https://api.trongrid.io/wallet/createtransaction";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, Object> request = new HashMap<>();
        request.put("to_address", to_address);
        request.put("owner_address", owner_address);
        request.put("amount",amount);
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(request,headers);
        ResponseEntity<Transaction> response = this.restTemplate.postForEntity(url,entity,Transaction.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println(response.getBody());
            return response.getBody();
        } else {
            return null;
        }
    }

    @Override
    public Result broadcastTransactionHex(String transaction) {
        String url = "https://api.trongrid.io/wallet/broadcasthex";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, Object> request = new HashMap<>();
        request.put("transaction", transaction);
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(request,headers);
        ResponseEntity<Result> response = this.restTemplate.postForEntity(url, entity, Result.class);
        System.out.println(response.getBody());
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    @Override
    public Result broadcastTransaction(String[] signature, String txID, JSONObject rawData, String raw_data_hex) {
        String url = "https://api.trongrid.io/wallet/broadcasttransaction";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        JSONObject request = new JSONObject();
        request.put("visible", false);
        request.put("signature", signature);
        request.put("txID", txID);
        request.put("raw_data", rawData);
        request.put("raw_data_hex", raw_data_hex);

        HttpEntity<JSON> entity = new HttpEntity<>(request,headers);

        ResponseEntity<Result> response = this.restTemplate.postForEntity(url, entity, Result.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            return null;
        }

        return response.getBody();
    }

    @Override
    public Account accountInfoByAddress(String address) {
        String url = "https://api.trongrid.io/wallet/getaccount";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, Object> request = new HashMap<>();
        request.put("address", address);
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(request,headers);
        ResponseEntity<Account> response = this.restTemplate.postForEntity(url, entity, Account.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    @Override
    public AccountInfo getAccountInfoByAddress(String address){
        String url = "https://api.trongrid.io/v1/accounts/";
        String urlRes = url.concat(address);
        ResponseEntity<AccountInfo> response = this.restTemplate.getForEntity(urlRes, AccountInfo.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
