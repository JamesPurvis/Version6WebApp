package me.jamespurvis.version6webapp.repository;

import me.jamespurvis.version6webapp.models.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Optional<Avatar> findById(Long id);
    Optional<Avatar> findByUsername(String Username);
}
