package com.example.jwt_auth.security.jwt;

import com.example.jwt_auth.users.dtos.UserResponseDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtAuthentication implements Authentication {
    private String jwtString;
    private UserResponseDto user;

    public JwtAuthentication(String jwtString) {
        this.jwtString = jwtString;
    }
    void setUser(UserResponseDto user) {
        this.user = user;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO: not needed for now,unless we have different resources accessible to differrnt roles
        return null;
    }

    @Override
    public String getCredentials() {
        //This is where we return the string/token that is used for authentication
        return jwtString;
    }

    @Override
    public Authentication getDetails() {
        return null;
    }

    @Override
    public UserResponseDto getPrincipal() {
        // This is where we return the user/client who is getting authenticated
        return user;
    }

    @Override
    public boolean isAuthenticated() {
        return (user != null);
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {

    }
}
