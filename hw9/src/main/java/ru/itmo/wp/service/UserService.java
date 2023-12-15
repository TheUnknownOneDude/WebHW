package ru.itmo.wp.service;

import org.springframework.stereotype.Service;
import ru.itmo.wp.domain.*;
import ru.itmo.wp.form.PostForm;
import ru.itmo.wp.form.UserCredentials;
import ru.itmo.wp.repository.RoleRepository;
import ru.itmo.wp.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PostService postService;

    /**
     * @noinspection FieldCanBeLocal, unused
     */
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, PostService postService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.postService = postService;

        this.roleRepository = roleRepository;
        for (Role.Name name : Role.Name.values()) {
            if (!roleRepository.existsByName(name)) {
                roleRepository.save(new Role(name));
            }
        }
    }



    public User register(UserCredentials userCredentials) {
        User user = new User();
        user.setLogin(userCredentials.getLogin());
        userRepository.save(user);
        userRepository.updatePasswordSha(user.getId(), userCredentials.getLogin(), userCredentials.getPassword());
        return user;
    }

    public boolean isLoginVacant(String login) {
        return userRepository.countByLogin(login) == 0;
    }

    public User findByLoginAndPassword(String login, String password) {
        return login == null || password == null ? null : userRepository.findByLoginAndPassword(login, password);
    }

    public User findById(Long id) {
        return id == null ? null : userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAllByOrderByIdDesc();
    }

    public void writePost(User user, PostForm postForm) {
        String[] rawTags = postForm.getTags().trim().split(" ");
        List<Tag> tags  = Arrays.stream(rawTags).distinct().map(Tag::new).collect(Collectors.toList());
        Post post = new Post();
        post.setTitle(postForm.getTitle());
        post.setText(postForm.getText());

        tags.forEach((tag) -> {
            Tag foundTag = postService.findByName(tag);
            if (foundTag == null) {
                foundTag = postService.save(tag);
            }
            tag.setId(foundTag.getId());
        });

        post.setTags(tags);
        user.addPost(post);
        post.setUser(user);
        userRepository.save(user);
    }
}
