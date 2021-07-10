package com.functional.pgming.java.warmup.funcexercisebasic.model;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Excercise_Function {

    Function<String,Book>  convertBook= (bookString)->{
        var bookDetailsArr = bookString.split(",");
        var i=0;
        Book bookBuilder =  Book.builder().id(bookDetailsArr[i++]).title(bookDetailsArr[i++]).authors(bookDetailsArr[i++]).avgRating(bookDetailsArr[i++]).isbn(bookDetailsArr[i++]).build();
        return bookBuilder;
    };



}
