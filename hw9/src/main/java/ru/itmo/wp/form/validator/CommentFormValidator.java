package ru.itmo.wp.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.itmo.wp.form.CommentForm;
import ru.itmo.wp.form.PostForm;
import ru.itmo.wp.service.PostService;

import java.util.Arrays;

@Component
public class CommentFormValidator implements Validator {
    PostService postService;

    public CommentFormValidator(PostService postService) {
        this.postService = postService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CommentForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            CommentForm commentForm = (CommentForm) target;
            if (commentForm.getText().trim().equals("")) {
                errors.rejectValue("text", "text.invalid input",
                        "write text pls");
            }
        }
    }
}
