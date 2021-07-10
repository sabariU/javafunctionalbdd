package com.functional.pgming.java.warmup.funcexercisebasic.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private String id;
    private String title;
    private String authors;
    private String avgRating;
    private String isbn;
}
