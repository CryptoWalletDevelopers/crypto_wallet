package com.cryptowallet.services;

import com.cryptowallet.repositories.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeService {
    private NodeRepository nodeRepository;

    @Autowired
    public void setNodeRepository(NodeRepository nodeRepository){
        this.nodeRepository = nodeRepository;
    }
}
