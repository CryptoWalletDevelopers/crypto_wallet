package com.cryptowallet.services.interfaces;

import com.cryptowallet.entities.Role;
import org.springframework.lang.NonNull;

import java.util.Collection;
import java.util.Optional;

public interface RoleService {

    Optional<Role> getRoleById(@NonNull int id);

    Collection<Role> addToCollection(@NonNull Role role);
}
