package com.cryptowallet.services;

import com.cryptowallet.entities.Role;
import com.cryptowallet.repositories.RoleRepository;
import com.cryptowallet.utils.UsersRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService {
    private final Set<Role> authorities = new HashSet<>();

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> getRoleById(int id) {
        return roleRepository.findById(id);
    }

    public Collection<Role> getAuthorities(int roleID) {
        authorities.add(getRoleById(roleID).get());
        return authorities;
    }
}
