package org.dev.backend.l_springdatajdbcdataaccess.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class Post {

    @Id
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime publishDate;
    private LocalDateTime updateDate;
    private AggregateReference<Author, Integer> author;
    private Set<Comment> comments = new HashSet<>();

    public Post(String title, String content, AggregateReference<Author, Integer> author) {
        this.title = title;
        this.content = content;
        this.publishDate = LocalDateTime.now();
        this.updateDate = null;
        this.author = author;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setPost(this);
    }
}
