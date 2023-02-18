package com.example.jwt_auth.users;

import com.example.jwt_auth.security.AuthTokenService;
import com.example.jwt_auth.security.jwt.JwtService;
import com.example.jwt_auth.users.dtos.CreateUserDto;
import com.example.jwt_auth.users.dtos.LoginUserDto;
import com.example.jwt_auth.users.dtos.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthTokenService authTokenService;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, AuthTokenService authTokenService, JwtService jwtService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.authTokenService = authTokenService;
        this.jwtService = jwtService;
    }

    public UserResponseDto createUser(CreateUserDto request) {
        // server side token
        var user = modelMapper.map(request, UserEntity.class); // convert CreateUserDto to UserEntity
        user.setPassword(passwordEncoder.encode(request.getPassword())); // here encode simply means Hashing
        var savedUser = userRepository.save(user); // save user in database
        var response = modelMapper.map(savedUser, UserResponseDto.class); // convert UserEntity to UserResponseDto to send it during sending response
        // Option1 : server side token
//        var token = authTokenService.createToken(savedUser); // create token for user
//        response.setToken(token); // set token in response
        // Option2 : JWT token
        var token = jwtService.createToken(savedUser.getUsername()); // JWT token crated
        response.setToken(token); // set token in response
        return response;
    }

    public UserResponseDto verifyUser(LoginUserDto request) {
        UserEntity user = userRepository.findByUsername(request.getUsername());
          if (user == null) {
                throw new RuntimeException("User not found");
          }
          if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) { // first parameter is raw password and second one is Hashed Password
                throw new RuntimeException("Wrong password");
          }
          var response = modelMapper.map(user, UserResponseDto.class);
          response.setToken(authTokenService.createToken(user));
          return response;
    }
    // method to get user from username
    public UserResponseDto findUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        var response = modelMapper.map(user, UserResponseDto.class);
        return response;
    }
}
// For dependency injection either  we can use @Autowired or constructor injection and right now we're following constructor injection
// var automatically detects the type of variable just like "auto" in c++
// TODO:baeldung.com/spring-security-login && spring.io spring security login