package me.jamespurvis.version6webapp.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DasboardController {


    @GetMapping("/dashboard")
    @PreAuthorize("isAuthenticated()")
    public String showDashboard() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return "dashboard";
    }
}
