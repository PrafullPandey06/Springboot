package com.example.jwt_auth.security.authtoken;

import com.example.jwt_auth.users.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "auth_tokens")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthTokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID  token;

    @ManyToOne
    private UserEntity user;
}
// Server Side token