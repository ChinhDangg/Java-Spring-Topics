package org.dev.database.l_graphqlspringbootintro.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Rating {
    FIVE_STARS("Five"),
    FOUR_STARS("Four"),
    THREE_STARS("Three"),
    TWO_STARS("Two"),
    ONE_STARS("One");

    private String star;

    Rating(String star) {
        this.star = star;
    }

    @JsonValue
    public String getStar() {
        return star;
    }
}
