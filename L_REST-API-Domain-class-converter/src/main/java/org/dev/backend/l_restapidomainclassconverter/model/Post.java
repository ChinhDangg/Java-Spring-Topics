package org.dev.backend.l_restapidomainclassconverter.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter @Setter
@ToString
@Entity
public class Post {

    @Id
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime publishedDate;
    private LocalDateTime updatedDate;

    public Post(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.publishedDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }
}
