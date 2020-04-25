package com.cryptowallet.services;

import com.cryptowallet.entities.Role;
import com.cryptowallet.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Collection<Role> getAllRolesById(int id) {
        return roleRepository.findAllById(id);
    }

}
