package ru.itmo.wp.web.page;

import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.web.exception.RedirectException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@SuppressWarnings({"unused"})
public class LogoutPage extends Page {

    @Override
    protected void action(HttpServletRequest request, Map<String, Object> view) {

        eventService.Logout((User) request.getSession().getAttribute("user"));
        request.getSession().removeAttribute("user");

//        request.getSession().setAttribute("message", "Good bye. Hope to see you soon!");
        setMessage("Good bye. Hope to see you soon!");
        throw new RedirectException("/index");
    }
}
