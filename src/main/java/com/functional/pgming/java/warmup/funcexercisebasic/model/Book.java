package com.functional.pgming.java.warmup.funcexercisebasic.model;

import lombok.Data;

@Data
public class Book {
    private String id;
    private String title;
    private String authors;
    private String avgRating;
    private String isbn;
}
