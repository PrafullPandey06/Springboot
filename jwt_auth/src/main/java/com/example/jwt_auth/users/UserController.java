package com.example.jwt_auth.users;

import com.example.jwt_auth.users.dtos.CreateUserDto;
import com.example.jwt_auth.users.dtos.LoginUserDto;
import com.example.jwt_auth.users.dtos.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("")
    public ResponseEntity<UserResponseDto> createUser(
            @RequestBody CreateUserDto request
    ) {
       var createdUser = userService.createUser(request);
       return ResponseEntity.created(URI.create("/users/")).body(createdUser);
    }
    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> verifyUser(
            @RequestBody LoginUserDto request
    ) {
        var verifiedUser = userService.verifyUser(request);
        return ResponseEntity.ok(verifiedUser);
    }
}

// For other cases we will use error handler UserResponseDto will carry the user object which is to be
// returned to the client
