-- Insert a few sample articles
INSERT INTO article (title, content, publish_date) VALUES
                                                       ('First Blog Post', 'This is the content of the first post.', '2026-02-20'),
                                                       ('Learning Spring Boot', 'I am currently building a blog using JPA and H2.', '2026-02-25'),
                                                       ('Why I love Engineering', 'Building systems from scratch is the best way to learn.', '2026-02-26');

-- If you have a separate table for tags (due to @ElementCollection)
-- The table name is usually 'article_tags' by default
INSERT INTO article_tags (article_id, tags) VALUES
                                                (1, 'General'),
                                                (2, 'Java'),
                                                (2, 'Spring'),
                                                (3, 'Engineering');