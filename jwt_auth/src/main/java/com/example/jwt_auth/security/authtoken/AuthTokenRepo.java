package com.example.jwt_auth.security.authtoken;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthTokenRepo extends JpaRepository<AuthTokenEntity, String> {
}
