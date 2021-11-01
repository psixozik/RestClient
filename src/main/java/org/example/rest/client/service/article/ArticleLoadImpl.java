package org.example.rest.client.service.article;

import lombok.extern.slf4j.Slf4j;
import org.example.rest.client.model.NYTArticleDBModel;
import org.example.rest.client.repository.ArticlesRepository;
import org.example.rest.client.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleLoadImpl implements ArticleLoadService {

    private final ArticlesRepository articlesRepository;
    private final UserRepository userRepository;

    @Autowired
    public ArticleLoadImpl(ArticlesRepository articlesRepository,
                           UserRepository userRepository) {
        this.articlesRepository = articlesRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Cacheable(cacheNames = "articles", unless = "#result == null")
    public NYTArticleDBModel loadArticlesByIdClient(String id) {

        try {
            String date = userRepository.getById(id).getBirthDate();
            return articlesRepository.getByDate(date);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Ошибка загрузки данных по ID: " + id);
        }
        return null;
    }
}
