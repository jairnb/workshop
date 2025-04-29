package com.workshop.authenticationserver.model;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails, CredentialsContainer {

    private String username;

    private String password;

    // UserDetails implementation...

    @Override
    public void eraseCredentials() {
        this.password = null; // Securely dereference the password field
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}