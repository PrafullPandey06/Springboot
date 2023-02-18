package com.example.jwt_auth.security.jwt;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.AuthenticationFilter;

import javax.servlet.http.HttpServletRequest;

public class JwtAuthenticationFilter extends AuthenticationFilter {
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager, new JwtAuthenticationConverter());

        // Retrieve user information in spring security - Baeldung
        this.setSuccessHandler((request, response, authentication) -> {
            SecurityContextHolder.getContext().setAuthentication(authentication); // whenever manager will return some non null authentication object

             // now every where inside controller this object is available                                                                      // then this authentication contains user and we will pass this user to entire project once it's authenticated
        });
    }
}
// now we need to create auth manager and auth converter without them we can't implement authentication filter
// As JwtAuthenticationConverter has empty constructor so we can simply create it at the time of creating JwtAuthenticationFilter
// But JwtAuthenticationManager has constructor with parameters so we need to create it before creating JwtAuthenticationFilter
// And manager can only be created after creating JwtService and UserService so we need to create them before creating JwtAuthenticationManager
// so at AppSecurity config we have JwtService and UserService as beans so we can use them in creating  JwtAuthenticationManager
//-------------------------------------------------------------------------------------------------------------------------------------------------