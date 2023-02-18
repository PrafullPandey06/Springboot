package com.example.jwt_auth.about;

import com.example.jwt_auth.users.dtos.UserResponseDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("")
    public String test(@AuthenticationPrincipal UserResponseDto user) {
        var usermail = user.getEmail();
        return "This is a test page. And your email is :" + usermail ;
    }
}
//@AuthenticationPrincipal UserResponseDto user will let us access user object anywhere in the code
