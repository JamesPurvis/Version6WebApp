package me.jamespurvis.version6webapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


}