package ru.itmo.wp.web.page;

import org.checkerframework.checker.units.qual.A;
import ru.itmo.wp.model.domain.Article;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.exception.ValidationException;
import ru.itmo.wp.model.repository.impl.ArticleRepositoryImpl;
import ru.itmo.wp.model.service.ArticleService;
import ru.itmo.wp.model.service.UserService;
import ru.itmo.wp.web.exception.RedirectException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ArticlePage {
    private final ArticleService articleService = new ArticleService();
//    private final UserService userService = new UserService();

    private void action(HttpServletRequest request, Map<String, Object> view) {
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            request.getSession().setAttribute("error", "This page is only for logged users");
            request.getSession().setAttribute("message", "This page is only for logged users");
            throw new RedirectException("/index");
        }

    }

    private void postArticle(HttpServletRequest request, Map<String, Object> view) throws ValidationException {
        String title = request.getParameter("title");
        String text = request.getParameter("text");
        User user = (User) request.getSession().getAttribute("user");

        Article article = new Article();
        article.setTitle(title);
        article.setText(text);
        article.setUserId(user.getId());
//        request.getSession().setAttribute("user", user);
//        request.getSession().setAttribute("message", "Hello, " + user.getLogin());

        articleService.validateArticle(article);
        articleService.addNewArticle(article);
        throw new RedirectException("/index");
    }
}
