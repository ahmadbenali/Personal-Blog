package com.Myblog.Service;

import com.Myblog.Models.Article;
import com.Myblog.Repository.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private final ArticleRepository repository;

    // Constructor Injection is the "Pro" way to use @Autowired
    //??
    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    //??
    public Iterable<Article> getAllArticles() {
        return repository.findAll();
    }


    public Article saveArticle(Article article) {
        return repository.save(article);
    }


}
