package me.jamespurvis.version6webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DasboardController {


    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard";
    }
}
