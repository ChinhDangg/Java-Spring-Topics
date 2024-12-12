package org.dev.backend.l_springdatajdbcdataaccess.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;

@Getter @Setter
public class Comment {

    private String name;
    private String content;
    private LocalDateTime publishDate;
    private LocalDateTime updateDate;
    @Transient
    private Post post;

    public Comment(String name, String content) {
        this.name = name;
        this.content = content;
        this.publishDate = LocalDateTime.now();
        updateDate = null;
    }
}
