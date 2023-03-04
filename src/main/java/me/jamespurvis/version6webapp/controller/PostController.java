package me.jamespurvis.version6webapp.controller;



import me.jamespurvis.version6webapp.models.Post;
import me.jamespurvis.version6webapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping("news/posts/{postNumber}")
    public String findPost(@PathVariable("postNumber") Long postNumber, Model model) {


        Optional<Post> post = postService.findByid(postNumber);

        if (post.isPresent()) {
            model.addAttribute("post", post.get());
            return "post";
        } else {
            return "404";
        }
    }


    @GetMapping("/news/page/{pageNumber}")
    public String findPage(@PathVariable("pageNumber") int pageNumber, Model model) {

        int pageSize = 2;

        Page<Post> findPage = postService.findPage(pageNumber, pageSize);
        List<Post> posts = findPage.getContent();

        model.addAttribute("posts", posts);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", findPage.getTotalPages());
        model.addAttribute("totalElements", findPage.getTotalElements());

        return "news";
    }
}
