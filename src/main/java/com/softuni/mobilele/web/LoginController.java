package com.softuni.mobilele.web;

import com.softuni.mobilele.model.UserLoginDTO;
import com.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }
}
