package ru.itmo.wp.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.itmo.wp.domain.Post;
import ru.itmo.wp.form.PostForm;
import ru.itmo.wp.form.UserCredentials;
import ru.itmo.wp.service.PostService;

import java.util.Arrays;

@Component
public class PostFormValidator implements Validator {
    PostService postService;

    public PostFormValidator(PostService postService) {
        this.postService = postService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PostFormValidator.class.equals(clazz);
    }

    private boolean validateTags(PostForm postForm) {
        return Arrays.stream(postForm.getTags().trim().split(" ")).allMatch(str -> str.matches("[A-Za-z]{1,99}"))
                || postForm.getTags().trim().isEmpty();
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            PostForm postForm = (PostForm) target;
            if (!validateTags(postForm)) {
                errors.rejectValue("tags", "tags.invalid-tag-unput",
                        "write tags in lower case, split them with \" \" symbol");
            }
        }
        System.out.println("post unvalidated");
    }
}
