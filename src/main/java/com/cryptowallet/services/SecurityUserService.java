package com.cryptowallet.services;

import com.cryptowallet.entities.Role;
import com.cryptowallet.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SecurityUserService implements UserDetailsService {
    private final UserServiceDefault userServiceDefault;
    private final RoleServiceImpl roleServiceImpl;

    @Autowired
    public SecurityUserService(UserServiceDefault userServiceDefault, RoleServiceImpl roleServiceImpl) {
        this.userServiceDefault = userServiceDefault;
        this.roleServiceImpl = roleServiceImpl;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(@NonNull String login) throws UsernameNotFoundException {
        User user = userServiceDefault.findByLoginOrEmail(login).get();
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                mapRolesToAuthorises(roleServiceImpl.addToCollection(user.getRole())));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorises(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getTitle())).collect(Collectors.toList());
    }
}
