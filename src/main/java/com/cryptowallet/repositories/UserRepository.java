package com.cryptowallet.repositories;

import com.cryptowallet.entities.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
   User findUserByEmail(@NonNull String email);
}
