package com.functional.pgming.java.warmup.funcexercisebasic;

import com.functional.pgming.java.warmup.funcexercisebasic.model.Book;
import com.functional.pgming.java.warmup.funcexrcisebdd.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

public class Ex2_Function {

    //Supplier<Book> bookSupplier = Book::new;

    Function<String, Book> convertToBookUsingBuilder = bookStr ->{

        var colArr = bookStr.split(",");

        var i = 0;

        Book bookFromBuilder = Book.builder().id(colArr[i++]).
                title(colArr[i++]).authors(colArr[i++])
                .avgRating(colArr[i++]).isbn(colArr[i++]).build();

        Book bookFromBuilder1 = Book.builder().id(colArr[i++]).
                title(colArr[i++]).authors(colArr[i++]).build();

        return bookFromBuilder;
    };


    Function<String, Book> convertToBook = bookStr ->{

        var colArr = bookStr.split(",");

        var i = 0;
        Book book = Book.builder().build();

        book.setId(colArr[i++]);
        book.setTitle(colArr[i++]);
        book.setAuthors(colArr[i++]);
        book.setAvgRating(colArr[i++]);
        book.setIsbn(colArr[i++]);

        return book;
    };


    public Function<String,Integer> strLenFinderV3 =
            myString -> myString.length();


    public Function<String,Integer> strLenFinderV2 = (myString) -> {
            return myString.length();
    };


    public class StrLenFinderV1 implements Function<String,Integer>{

        @Override
        public Integer apply(String s) {
            return s.length();
        }
    }

}
