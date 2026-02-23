package com.Myblog.Repository;

import com.Myblog.Models.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article,Long> {

    List<Article> findByTagsContaining(String tag);
    List<Article> findByPublishDate(LocalDate date);
}
