package org.dev.test.jsontestswithjsontestannotation.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.dev.test.jsontestswithjsontestannotation.Type;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Appearance {

    private String id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Type type;
    private List<String> tags;
    private String url;
}
