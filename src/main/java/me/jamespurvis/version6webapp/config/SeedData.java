package me.jamespurvis.version6webapp.config;


import me.jamespurvis.version6webapp.models.Avatar;
import me.jamespurvis.version6webapp.models.Post;
import me.jamespurvis.version6webapp.repository.AvatarRepository;
import me.jamespurvis.version6webapp.services.AvatarService;
import me.jamespurvis.version6webapp.services.PostService;
import org.hibernate.cfg.annotations.reflection.internal.JPAXMLOverriddenAnnotationReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private AvatarService avatarService;

    @Autowired
    private PostService postService;

    @Override
    public void run(String... args) throws Exception {

        Avatar avatar = new Avatar();
        avatar.setEmail("cool@poopie.com");
        avatar.setFigure("1000118001270012900121001");
        avatar.setUsername("Admin");
        avatar.setPassword("lol123");
        avatar.setUser_role("ROLE_ADMIN");

        Avatar avatar2 = new Avatar();
        avatar.setEmail("admin@lol.com");
        avatar.setFigure("1000118001270012900121001");
        avatar2.setUsername("Andy");
        avatar2.setPassword("123123");
        avatar2.setUser_role("ROLE_USER");

        avatarService.save(avatar);
        avatarService.save(avatar2);

        List<Post> posts = postService.getAll();

        if (posts.size() == 0) {
            Post post1 = new Post();
            post1.setBody("Hello, this is post 1");
            post1.setAvatar(avatar);
            post1.setTitle("Post 1");

            Post post2 = new Post();
            post2.setBody("Hello, this is post 2");
            post2.setAvatar(avatar2);
            post2.setTitle("Post 2");

            Post post3 = new Post();
            post3.setBody("Hello, this is post 3");
            post3.setAvatar(avatar);
            post3.setTitle("Post 3");

            Post post4 = new Post();
            post4.setBody("Hello, this is post 4");
            post4.setAvatar(avatar2);
            post4.setTitle("Post 4");

            Post post5 = new Post();
            post5.setBody("Hello, this is post 5");
            post5.setAvatar(avatar);
            post5.setTitle("Post 5");

            Post post6 = new Post();
            post6.setBody("Hello, this is post 6");
            post6.setAvatar(avatar2);
            post6.setTitle("Post 6");


            postService.save(post1);
            postService.save(post2);
            postService.save(post3);
            postService.save(post4);
            postService.save(post5);
            postService.save(post6);

        }

    }
}
