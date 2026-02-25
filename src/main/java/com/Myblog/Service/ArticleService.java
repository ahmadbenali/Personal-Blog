package com.Myblog.Service;

import com.Myblog.Models.Article;
import com.Myblog.Repository.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository repository;

    // Constructor Injection is the "Pro" way to use @Autowired
    //to make it available for use 
    public ArticleService(ArticleRepository repository)
    {
        this.repository = repository;
    }




    public Article findById(Long id)
    {
        return repository.findById(id).orElse(null);
    }

    public Article update(Article article)
    {
        return repository.save(article);
    }
    //??
    public Iterable<Article> getAllArticles()
    {
        return repository.findAll();
    }

    public void deleteById(Long id)
    {
         repository.deleteById(id);
    }


    public Article saveArticle(Article article)
    {
        return repository.save(article);
    }


}
