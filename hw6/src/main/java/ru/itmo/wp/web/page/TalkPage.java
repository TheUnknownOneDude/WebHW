package ru.itmo.wp.web.page;

import ru.itmo.wp.model.domain.Talk;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.service.UserService;
import ru.itmo.wp.web.exception.RedirectException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class TalkPage extends Page {
//    private final UserService userService = new UserService();

    @Override
    protected void action(HttpServletRequest request, Map<String, Object> view) {
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            setMessage("U must be logged in");
            throw new RedirectException("/index");
        }

        view.put("users", userService.findAll());
        view.put("talks", talksService.findMessages(user));
    }

    private void sendMessageToTarget(HttpServletRequest request, Map<String, Object> view) {
        Talk talk = new Talk();
        User user = (User) request.getSession().getAttribute("user");
        talk.setSourceUserId(user.getId());
        talk.setTargetUserId(Long.parseLong(request.getParameter("targetUserId")));
        talk.setText(request.getParameter("messageText"));
        talksService.save(talk);
        view.put("talks", talksService.findMessages(user));
    }
}