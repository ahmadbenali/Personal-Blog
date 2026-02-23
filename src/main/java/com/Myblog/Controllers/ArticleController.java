package com.Myblog.Controllers;


import com.Myblog.Models.Article;
import com.Myblog.Service.ArticleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {


    private final ArticleService service;

    // Use Dependency Injection to bring in your Service
    public ArticleController(ArticleService service) {
        this.service = service;
    }

    // GET: Return a list of all articles
    @GetMapping
    public Iterable<Article> list() {
        return service.getAllArticles();
    }

    // POST: Create a new article
    @PostMapping
    public Article create(@RequestBody Article article) {
        return service.saveArticle(article);
    }

}
