package com.cryptowallet.services;

import com.cryptowallet.entities.Role;
import com.cryptowallet.repositories.RoleRepository;
import com.cryptowallet.services.interfaces.RoleService;
import com.cryptowallet.utils.UsersRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleServiceDefault implements RoleService {
    private final Set<Role> authorities = new HashSet<>();

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceDefault(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> getRoleById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public Collection<Role> addToCollection(Role role) {
        authorities.add(role);
        return authorities;
    }

    public Role getUserRole() {
        return getRoleById(UsersRoles.ROLE_USER.getRole()).get();
    }

    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}
