package ru.itmo.wp.model.service;

import com.google.common.base.Strings;
import ru.itmo.wp.model.domain.Article;
import ru.itmo.wp.model.exception.ValidationException;
import ru.itmo.wp.model.repository.ArticleRepository;
import ru.itmo.wp.model.repository.impl.ArticleRepositoryImpl;

import java.util.List;

public class ArticleService {
    ArticleRepository articleRepository = new ArticleRepositoryImpl();

    public void validateArticle(Article article) throws ValidationException {

        if (Strings.isNullOrEmpty(article.getTitle())) {
            throw new ValidationException("Title is required");
        }

        if (article.getTitle().length() > 255) {
            throw new ValidationException("Title must be less than 255 characters");
        }

        if (Strings.isNullOrEmpty(article.getText())) {
            throw new ValidationException("Text is required");
        }

        if (article.getText().length() > 10000) {
            throw new ValidationException("Article text must be less than 10000 characters");
        }

    }


    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public void addNewArticle(Article article) {
        articleRepository.save(article);
    }
}
