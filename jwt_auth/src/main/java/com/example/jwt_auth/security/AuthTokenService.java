package com.example.jwt_auth.security;

import com.example.jwt_auth.security.authtoken.AuthTokenEntity;
import com.example.jwt_auth.security.authtoken.AuthTokenRepo;
import com.example.jwt_auth.users.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenService {
    private final AuthTokenRepo authTokenRepo;
    public AuthTokenService(AuthTokenRepo authTokenRepo) {
        this.authTokenRepo = authTokenRepo;
    }

    public String createToken(UserEntity userEntity) {
        var token = new AuthTokenEntity();  // new token contains token and userObject
        token.setUser(userEntity); // set userObject
        authTokenRepo.save(token); // save that token in token dataBase
        return token.getToken().toString(); // since token is UUID so we need to convert it into String
    }

    public UserEntity  getUserByToken(String token) {
        var authTokenEntity = authTokenRepo.findById(token).orElseThrow(() -> new RuntimeException("User not found"));
        return authTokenEntity.getUser();
    }
}
// server side token
// every time we will make login request we will get new toekn and it is stored like token : id in database
// and this token is UUID which is universal unique
