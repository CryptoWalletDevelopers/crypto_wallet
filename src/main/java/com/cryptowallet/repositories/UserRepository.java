package com.cryptowallet.repositories;

import com.cryptowallet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLogin(String login);

    boolean existsByEmail(String login);

    User findByLogin(String login);

    User findByToken (String token);

    User findByEmail(String email);
}
