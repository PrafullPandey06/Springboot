package com.example.jwt_auth.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class  JwtService {
    public static final String SECRET = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXUyJ9.eyJpc3MiOiJhdXRoMCJ9.AbIJTDMFc7yUa5MhvcP03nJPyCPzZtQcGEp-zWfOkEE";
    Algorithm algorithm = Algorithm.HMAC256(SECRET); // https://github.com/auth0/java-jwt

    // set token to login user
    public String createToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuedAt(new Date())
                .sign(algorithm);
    }
    public String getUsernameFromJwt(String token) {
        return JWT.require(algorithm)
                .build()
                .verify(token)
                .getSubject();
    }
}
// for jwt we don't require Entity or Repository, we will use it in JwtFilter
// As we login multiple times so we will get multiple tokens, as time will change so we will get different tokens each time
