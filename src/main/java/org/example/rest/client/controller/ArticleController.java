package org.example.rest.client.controller;

import org.example.rest.client.model.NYTArticleDBModel;
import org.example.rest.client.service.article.ArticleLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {

    ArticleLoadService articleLoadService;

    @Autowired
    public ArticleController(ArticleLoadService articleLoadService) {
        this.articleLoadService = articleLoadService;
    }

    @GetMapping("/art")
    public ResponseEntity<List<NYTArticleDBModel.Doc>> postResponseController(@RequestParam String id) {

       NYTArticleDBModel nytArticleDBModel = articleLoadService.loadArticlesByIdClient(id);
       if(nytArticleDBModel != null)
           return ResponseEntity.ok(nytArticleDBModel.getListOfArticles());
       return ResponseEntity.internalServerError().body(new ArrayList<>());
    }
}
