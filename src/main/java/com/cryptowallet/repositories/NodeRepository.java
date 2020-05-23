package com.cryptowallet.repositories;

import com.cryptowallet.entities.Currency;
import com.cryptowallet.entities.Node;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NodeRepository extends JpaRepository<Node, Long> {
    Optional<List<Node>> findNodesByCurrency(@NonNull Currency currency);
}
