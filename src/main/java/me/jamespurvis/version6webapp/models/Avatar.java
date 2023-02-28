package me.jamespurvis.version6webapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "avatars")
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String username;
    private String password;
    private String email;

    private String figure;

    private String mission;

    private String persistent_message;

    private int tickets;

    private int film;

    private int credits;

    private char sex;

    private String pool_figure;

    private String user_role;

    public Collection<? extends SimpleGrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(getUser_role()));
    }

}