package com.softuni.mobilele.web;

import com.softuni.mobilele.model.user.MobileleUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal UserDetails userDetails,
                       Model model) {

        if (userDetails instanceof  MobileleUserDetails mobileleUserDetails) {
            model.addAttribute("welcomeMessage", mobileleUserDetails.getFullName());
        } else {
            model.addAttribute("welcomeMessage", "Anonymous");
        }

        return "index";
    }
}
