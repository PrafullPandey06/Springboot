package com.example.jwt_auth.security.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationConverter;

import javax.servlet.http.HttpServletRequest;

public class JwtAuthenticationConverter implements AuthenticationConverter {
    @Override
    public Authentication convert(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization"); // we need to get auth header from request
        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            var token = authHeader.substring(7); // we need to get token from auth header
            return new JwtAuthentication(token); // we need to create authentication object from token and send it to AuthenticationManager
        }
        return null;
    }
}
// in converter we've http request and we need to create authentication object from it