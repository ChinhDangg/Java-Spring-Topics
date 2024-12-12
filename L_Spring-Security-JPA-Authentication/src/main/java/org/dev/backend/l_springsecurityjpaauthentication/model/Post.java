package org.dev.backend.l_springsecurityjpaauthentication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Post {

    @Id @GeneratedValue
    private Long id;
    private String title;
    private String slug;
    private String content;
    private String author;
    private LocalDateTime publishDate;
    private LocalDateTime updateDate;

    public Post(String title, String slug, String content, String author) {
        this.title = title;
        this.slug = slug;
        this.content = content;
        this.author = author;
    }
}
