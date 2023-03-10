package me.jamespurvis.version6webapp.services;


import me.jamespurvis.version6webapp.models.Avatar;
import me.jamespurvis.version6webapp.models.Post;
import me.jamespurvis.version6webapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

@Service
public class PostService {

    @Autowired
   private PostRepository postRepository;

    public Optional<Post> findByid(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> getAll() {

        return postRepository.findAll();
    }

    public Page<Post> findPage(int pageNumber, int pageSize) {
        Pageable pageRequest = PageRequest.of(pageNumber - 1, pageSize);

        return postRepository.findAll(pageRequest);
    }


    public Post save(Post post) {

        System.out.println(post.getTitle());

        if (post.getId() == null) {
            post.setCreatedAt(LocalDateTime.now());
        } else {
            post.setUpdatedAt(LocalDateTime.now());
        }

        return postRepository.save(post);
    }
}
