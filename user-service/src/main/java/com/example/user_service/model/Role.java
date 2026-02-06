package com.example.user_service.model;

import lombok.Getter;

@Getter
public enum Role {

    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN"),
    ROLE_DOCTOR("DOCTOR");

    private final String role;
    Role(String role) {
        this.role = role;
    }
}
