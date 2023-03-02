package me.jamespurvis.version6webapp.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {

    @RequestMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String showProfilePage() {
        return "profile";
    }

    @RequestMapping("/profile_avatar")
    @PreAuthorize("isAuthenticated()")
    public String showUpdatePage() {
        return "profile_avatar";
    }
}
