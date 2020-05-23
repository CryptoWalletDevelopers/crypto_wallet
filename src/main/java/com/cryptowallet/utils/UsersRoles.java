package com.cryptowallet.utils;

public enum UsersRoles {
    ROLE_USER(1),
    ROLE_ADMIN(2);

    private final int role;
    UsersRoles (int role) {
        this.role = role;
    }

    public int getRole() {
        return role;
    }
}
