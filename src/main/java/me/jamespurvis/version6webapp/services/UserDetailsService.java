package me.jamespurvis.version6webapp.services;


import me.jamespurvis.version6webapp.models.Avatar;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component("UserDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private AvatarService avatarService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Avatar> optionalAvatar = avatarService.findByUsername(username);

        if (!optionalAvatar.isPresent()) {
            throw new UsernameNotFoundException("Account not found with those specified details!");
        }


        Avatar avatar = optionalAvatar.get();

        return new User(avatar.getUsername(), avatar.getPassword(), avatar.getAuthorities());
    }
}
