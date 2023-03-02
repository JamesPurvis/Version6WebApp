package me.jamespurvis.version6webapp.controller;


import me.jamespurvis.version6webapp.models.Avatar;
import me.jamespurvis.version6webapp.services.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    private AvatarService avatarService;

    @RequestMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String showProfilePage() {
        return "profile";
    }

    @RequestMapping("/profile_avatar")
    @PreAuthorize("isAuthenticated")
    public String showUpdatePage(Model model) {
      UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Avatar> avatar = avatarService.findByUsername(userDetails.getUsername());

        model.addAttribute("mission", avatar.get().getMission());
        model.addAttribute("credits", avatar.get().getCredits());
        model.addAttribute("role", avatar.get().getUser_role());
        model.addAttribute("email", avatar.get().getEmail());
        model.addAttribute("figure", avatar.get().getFigure());
        model.addAttribute("id", avatar.get().getId());
        model.addAttribute("film", avatar.get().getFilm());
        model.addAttribute("tickets", avatar.get().getTickets());
        model.addAttribute("persistent_message", avatar.get().getPersistent_message());
        model.addAttribute("pool_figure", avatar.get().getPool_figure());
        model.addAttribute("sex", avatar.get().getSex());

        return "profile_avatar";
    }
}
