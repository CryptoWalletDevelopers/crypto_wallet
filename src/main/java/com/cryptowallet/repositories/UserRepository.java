package com.cryptowallet.repositories;

import com.cryptowallet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLogin(String login);

    boolean existsByEmail(String email);

    boolean existsByLoginOrEmail(String login, String email);

    Optional<User> findByLogin(String login);

    Optional<User> findByToken (String token);

    Optional<User> findByEmail(String email);

    Optional<User> findByLoginOrEmail(String login, String email);
}
