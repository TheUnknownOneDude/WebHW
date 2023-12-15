package ru.itmo.wp.web.page;

import com.google.common.base.Strings;
import ru.itmo.wp.model.domain.Event;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.repository.TalkRepository;
import ru.itmo.wp.model.service.EventService;
import ru.itmo.wp.model.service.TalkService;
import ru.itmo.wp.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Page {
    protected final UserService userService = new UserService();
    protected final EventService eventService = new EventService();
    protected final TalkService talksService = new TalkService();
    HttpServletRequest currentRequest;


    protected void action(HttpServletRequest request, Map<String, Object> view) {
        // No operations
    }

    void before(HttpServletRequest request, Map<String, Object> view) {

        currentRequest = request;

        view.put("userCount", userService.findCount());

        User user = (User) currentRequest.getSession().getAttribute("user");

        if (user != null)
            view.put("user", user);



        String message = (String) request.getSession().getAttribute("message");
        if (!Strings.isNullOrEmpty(message)) {
            view.put("message", message);
            request.getSession().removeAttribute("message");
        }

    }

    void after(HttpServletRequest request, Map<String, Object> view) {

    }

    public void setMessage(String message) {
        currentRequest.getSession().setAttribute("message", message);
    }
}
