package com.cryptowallet.repositories;

import com.cryptowallet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLogin(@NonNull String login);

    boolean existsByEmail(@NonNull String email);

    boolean existsByLoginOrEmail(@NonNull String login, String email);

    Optional<User> findByLogin(@NonNull String login);

    Optional<User> findByToken (@NonNull String token);

    Optional<User> findByEmail(@NonNull String email);

    Optional<User> findByLoginOrEmail(@NonNull String login, @NonNull String email);
}
