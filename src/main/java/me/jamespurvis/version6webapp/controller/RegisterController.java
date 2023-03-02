package me.jamespurvis.version6webapp.controller;


import me.jamespurvis.version6webapp.models.Avatar;
import me.jamespurvis.version6webapp.services.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class RegisterController {

    @Autowired
    private AvatarService avatarService;


    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute Avatar avatar) {

        Optional<Avatar> existingUser = avatarService.findByUsername(avatar.getUsername());

        if (existingUser.isPresent()) {
            return "redirect:/register?error_name_taken";
        }


        avatar.setUser_role("ROLE_USER");
        avatar.setFigure("1000118001270012900121001");
        avatar.setPersistent_message("I am a new user!");

        avatarService.save(avatar);

        return "/register_success";
    }
}
