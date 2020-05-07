package com.cryptowallet.services;

import com.cryptowallet.repositories.NodeRepository;
import com.cryptowallet.services.interfaces.NodeService;
import lombok.NonNull;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeServiceImpl implements NodeService {
    private NodeRepository nodeRepository;

    @Autowired
    public NodeServiceImpl(@NonNull NodeRepository nodeRepository){
        this.nodeRepository = nodeRepository;
    }
}
