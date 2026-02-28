package com.rajkhatri.dev.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/UserHome";
    }

    @GetMapping("/UserHome")
    public String home(@AuthenticationPrincipal OAuth2User user, Model model) {

        String fullName = user.getAttribute("name");
        String email = user.getAttribute("email");
        String picture = user.getAttribute("picture");
        String sub = user.getAttribute("sub");

        String firstName = fullName != null && fullName.contains(" ")
                ? fullName.split(" ")[0]
                : fullName;

        model.addAttribute("firstName", firstName);
        model.addAttribute("fullName", fullName);
        model.addAttribute("email", email);
        model.addAttribute("picture", picture);
        model.addAttribute("sub", sub);

        return "home";
    }

}