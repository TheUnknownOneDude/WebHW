package ru.itmo.wp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itmo.wp.domain.User;

import javax.servlet.http.HttpSession;

@Controller
public class UserPage extends Page {


    @GetMapping({"/user/", "/user/{id}" })
    public String user(@PathVariable String id, Model model, HttpSession httpSession) {

        System.out.println(id);
        if (id == null) {
            setMessage(httpSession, "Id must be integer!");
            return "redirect:/";
        }

        long longId;
        try {
                longId = Long.parseLong(id);
        } catch (NumberFormatException ignored) {
            setMessage(httpSession, "Id must be integer!");
            return "redirect:/";
        }


//        if (longId == null) {
//
//        }

        User user = userService.findById(longId);

        if (user == null) {
            setMessage(httpSession, "No user with such id!");
            return "redirect:/";
        }

        model.addAttribute("curUser", user);
        return "UserPage";
    }
}
