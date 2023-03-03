package me.jamespurvis.version6webapp.controller;



import me.jamespurvis.version6webapp.models.Post;
import me.jamespurvis.version6webapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/news")
    public String showNewsPage(Model model) {
        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);

        return "news";
    }
}
