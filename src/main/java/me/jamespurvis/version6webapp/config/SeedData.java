package me.jamespurvis.version6webapp.config;


import me.jamespurvis.version6webapp.models.Avatar;
import me.jamespurvis.version6webapp.repository.AvatarRepository;
import me.jamespurvis.version6webapp.services.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private AvatarService avatarService;

    @Override
    public void run(String... args) throws Exception {

        Avatar avatar = new Avatar();
        avatar.setUsername("Admin");
        avatar.setPassword("lol123");
        avatar.setUser_role("ROLE_ADMIN");

        Avatar avatar2 = new Avatar();
        avatar2.setUsername("Andy");
        avatar2.setPassword("123123");
        avatar2.setUser_role("ROLE_USER");


        avatarService.save(avatar);
        avatarService.save(avatar2);
    }
}
