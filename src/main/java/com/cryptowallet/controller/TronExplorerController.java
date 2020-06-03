package com.cryptowallet.controller;

import com.cryptowallet.API.blockchain.TronAPI;
import com.cryptowallet.models.tronModels.Block;
import com.cryptowallet.models.tronModels.Transaction;
import com.cryptowallet.models.tronModels.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.TreeMap;

@Controller
@RequestMapping("/explorer")
public class TronExplorerController {
    private String TITLE = "TronExplorer";
    private TronAPI tronAPI;

    @Autowired
    public TronExplorerController(TronAPI tronAPI) {
        this.tronAPI = tronAPI;
    }

    @GetMapping
    public String explorerPage( Model model){
        model.addAttribute("title",TITLE);
        long nowBlock  = getNowBlockNumber();
        model.addAttribute("nowBlockNumber", nowBlock);
        model.addAttribute("tableContent", getLastTenBlocksInfo(nowBlock));
        return "explorer";
    }

    @PostMapping("/findTransacton")
    public String findTransactionInfo(@RequestParam("transactionId") String transactionId, Model model){
        Transaction transaction = tronAPI.getTransactionInfoById(transactionId);
        Value value = transaction.getRawData().getContract()[0].getParameter().getValue();
        model.addAttribute("title",TITLE);
        long nowBlock  = getNowBlockNumber();
        model.addAttribute("nowBlockNumber", nowBlock);
        model.addAttribute("tableContent", getLastTenBlocksInfo(nowBlock));
        model.addAttribute("blockNumber", transaction.getBlockNumber());
        model.addAttribute("ownerAddress", value.getOwnerAddress());
        model.addAttribute("toAddress", value.getToAddress());
        model.addAttribute("amount", value.getAmount());
    return "explorer";
    }

    @PostMapping("/findBlock")
    public String findBlockInfo(@RequestParam("blockHash") String blockHash, Model model){
        Block block= tronAPI.getBlockInfoById(blockHash);
        model.addAttribute("title",TITLE);
        long nowBlock  = getNowBlockNumber();
        model.addAttribute("nowBlockNumber", nowBlock);
        model.addAttribute("tableContent", getLastTenBlocksInfo(nowBlock));
        model.addAttribute("blockNumber", block.getBlockHeader().getRawData().getNumber());
        model.addAttribute("parentHash", block.getBlockHeader().getRawData().getParentHash());
        model.addAttribute("witnessSignature", block.getBlockHeader().getWitnessSignature());
    return "explorer";
    }

    private TreeMap<Long,String> getLastTenBlocksInfo(Long nowBlock){
        int refNumber = nowBlock.intValue();
        TreeMap<Long,String> map = new TreeMap<>();
        for(int i=refNumber ;i>nowBlock-11;i--){
            map.put((long) i,tronAPI.getBlockByNum(i).getBlockID());
        }
        return map;
    }

    private Long getNowBlockNumber(){
        return tronAPI.getNowBlock().getBlockHeader().getRawData().getNumber();
    }
}
