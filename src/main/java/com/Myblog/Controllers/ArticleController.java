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

    @GetMapping("{id}")
    public Article getOne(@PathVariable long id) {
        return service.findById(id);
    }

    // POST: Create a new article
    @PostMapping
    //@RequestBody tells Spring Boot to look at the JSON data coming from
    //the user's web request and "map" it into a Java Object.
    public Article create(@RequestBody Article article) {
        //spring take the result of saveArtivle convert to json and send back
        return service.saveArticle(article);
    }

    @PutMapping("{id}")
    public Article update(@PathVariable Long id, @RequestBody Article newArticle) {

        newArticle.setId(id);
        return service.update(newArticle);

    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {

         service.deleteById(id);
         return "Article with ID " + id + " has been successfully deleted.";
    }

}
