package com.Myblog.Models;

import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

//Entity is a java object that will convert to JSON or JSON to java object
@Entity // Tells JPA to create a table for this class, without it will ignore it
public class Article {

    @Setter
    @Id // Marks this as the Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Database handles ID incrementing
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT") // Allows for long blog content
    private String content;

    private LocalDate publishDate;

    //Since a database table can't naturally store a "List" inside a single cell,
    //this tells JPA to manage the relationship for your tags automatically.
    @ElementCollection // Stores the tags list in a separate sub-table
    private List<String> tags;

    //*********************************************************************************************************

    // IMPORTANT: JPA needs a no-args constructor to work
    public Article() {}

    // Constructor for creating new articles
    public Article(String title, String content, LocalDate publishDate, List<String> tags) {
        this.title = title;
        this.content = content;
        this.publishDate = publishDate;
        this.tags = tags;
    }
    // for Update Getters and Setters go here...

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public LocalDate getPublishDate() { return publishDate; }
    public List<String> getTags() { return tags; }

}
