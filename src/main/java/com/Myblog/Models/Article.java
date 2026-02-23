package com.Myblog.Models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity // Tells JPA to create a table for this class, without it will ignore it
public class Article {

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

    // Getters and Setters go here...
}
