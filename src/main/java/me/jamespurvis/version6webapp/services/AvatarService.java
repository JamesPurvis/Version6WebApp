package me.jamespurvis.version6webapp.services;

import me.jamespurvis.version6webapp.models.Avatar;
import me.jamespurvis.version6webapp.repository.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AvatarService {

    @Autowired
    private AvatarRepository avatarRepository;

    public Optional<Avatar> findByid(Long id) {
        return avatarRepository.findById(id);
    }

    public Optional<Avatar> findByUsername(String username) {
        return avatarRepository.findByUsername(username);
    }

    public Avatar save(Avatar entity) {
       return avatarRepository.save(entity);
    }
}
