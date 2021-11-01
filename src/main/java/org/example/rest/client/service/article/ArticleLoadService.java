package org.example.rest.client.service.article;

import org.example.rest.client.model.NYTArticleDBModel;

public interface ArticleLoadService {

    NYTArticleDBModel loadArticlesByIdClient(String id);
}
