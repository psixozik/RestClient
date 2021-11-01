package org.example.rest.client.repository;

import org.example.rest.client.model.NYTArticleDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticlesRepository extends MongoRepository<NYTArticleDBModel, String> {
    NYTArticleDBModel getByDate(String date);
}
