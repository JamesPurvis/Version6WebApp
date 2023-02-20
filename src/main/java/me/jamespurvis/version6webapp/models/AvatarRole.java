package me.jamespurvis.version6webapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "avatar_roles")
@Getter
@Setter

public class AvatarRole {

    @Id
    public String name;

    public String fuse_rights;
}
