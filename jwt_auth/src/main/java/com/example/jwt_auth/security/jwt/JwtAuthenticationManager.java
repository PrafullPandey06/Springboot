package com.example.jwt_auth.security.jwt;

import com.example.jwt_auth.users.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

public class JwtAuthenticationManager implements AuthenticationManager {
    private JwtService jwtService;
    private UserService userService;
    public JwtAuthenticationManager(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }
    @Override
    public Authentication authenticate(Authentication authentication) {
        if(authentication instanceof JwtAuthentication) {
            var jwtAuthentication = (JwtAuthentication) authentication;
            var jwtString = jwtAuthentication.getCredentials(); // we need to get username from token which is made into object from converter in the form of class "JwtAuthentication"

            //TODO: crypto failure on jwt verification
            //TODO: check if jwt is expired so we will use try catch block

            var username = jwtService.getUsernameFromJwt(jwtString); // from the jwt string we need to get username(jwtService)
            var user = userService.findUserByUsername(username); // from the username we need to get user from db(userService)
            jwtAuthentication.setUser(user); // we need to set user in jwtAuthentication
            return jwtAuthentication; // we need to return jwtAuthentication
        }
        return null;
    }
}
