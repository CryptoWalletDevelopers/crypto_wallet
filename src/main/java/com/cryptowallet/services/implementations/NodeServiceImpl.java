package com.cryptowallet.services.implementations;

import com.cryptowallet.entities.Currency;
import com.cryptowallet.entities.Node;
import com.cryptowallet.repositories.NodeRepository;
import com.cryptowallet.services.interfaces.NodeService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NodeServiceImpl implements NodeService {
    private final NodeRepository nodeRepository;

    @Autowired
    public NodeServiceImpl(@NonNull NodeRepository nodeRepository){
        this.nodeRepository = nodeRepository;
    }

    @Override
    public Optional<List<Node>> findNodesByCurrency(@NonNull Currency currency) {
        return nodeRepository.findNodesByCurrency(currency);
    }
}
