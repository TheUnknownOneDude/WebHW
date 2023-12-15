package ru.itmo.wp.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.itmo.wp.domain.Comment;
import ru.itmo.wp.domain.Post;
import ru.itmo.wp.form.CommentForm;
import ru.itmo.wp.form.validator.CommentFormValidator;
import ru.itmo.wp.security.Guest;
import ru.itmo.wp.service.PostService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class PostPage extends Page {
    private final PostService postService;
    private final CommentFormValidator commentFormValidator;


    public PostPage(PostService postService, CommentFormValidator commentFormValidator) {
        this.postService = postService;
        this.commentFormValidator = commentFormValidator;
    }

    @InitBinder("commentForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(commentFormValidator);
    }


    @Guest
    @GetMapping("/post/{id}")
    public String postGet(@PathVariable String id, HttpSession httpSession, Model model) {


        if (id == null) {
            putMessage(httpSession, "Id must be integer!");
            return "redirect:/";
        }

        long longId;
        try {
            longId = Long.parseLong(id);
        } catch (NumberFormatException ignored) {
            putMessage(httpSession, "Id must be integer!");
            return "redirect:/";
        }


        Post post = postService.findById(longId);

        if (post == null) {
            putMessage(httpSession, "No post with such id");
            return "redirect:/";
        }


        model.addAttribute("commentForm", new CommentForm());
        model.addAttribute("curPost", post);
        model.addAttribute("curComments", post.getComments());
        return "PostPage";
    }

    @PostMapping("/post/writeComment")
    public String writeComment(@Valid @ModelAttribute("CommentForm") CommentForm commentForm, BindingResult bindingResult,
                               HttpSession httpSession, Model model) {

        Post post = postService.findById(commentForm.getPostId());

        if (bindingResult.hasErrors()) {
            return "redirect:/post/" + post.getId();
        }

        if (post == null) {
            putMessage(httpSession, "No post with such id");
            return "redirect:/";
        }

        Comment comment = new Comment();
        comment.setText(commentForm.getText());
        comment.setUser(getUser(httpSession));
        comment.setPost(post);
        postService.save(comment);
        model.addAttribute("curPost", post);
        model.addAttribute("curComments", post.getComments());
        return "redirect:/post/" + post.getId();
    }

}
