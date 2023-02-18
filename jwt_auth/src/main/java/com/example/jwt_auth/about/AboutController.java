package com.example.jwt_auth.about;

import com.example.jwt_auth.users.dtos.UserResponseDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/about")
public class AboutController {
    @GetMapping("")
    String about() {
        return "This is a JWT authentication example.";
    }
    @GetMapping("/private")
    String privateAbout(@AuthenticationPrincipal UserResponseDto user) {
        var username = user.getUsername();
        return "This is a private about information for logged users only." + "you are viewing this page as " + username;
    }
}
// this controller is accessable by anyone spring will provide automatic security but we dont want that
// we can't even get our about page as spring security will make every page secure
