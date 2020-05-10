package com.cryptowallet.services.interfaces;

import com.cryptowallet.entities.Currency;
import com.cryptowallet.entities.Node;
import com.cryptowallet.repositories.NodeRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public interface NodeService {
    public Optional<List<Node>> findNodesByCurrency(@NonNull Currency currency);
}
