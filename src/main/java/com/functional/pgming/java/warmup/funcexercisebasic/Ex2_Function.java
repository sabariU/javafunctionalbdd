package com.functional.pgming.java.warmup.funcexercisebasic;

import com.functional.pgming.java.warmup.funcexercisebasic.model.Book;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Ex2_Function {

    Supplier<Book> newBook = Book::new;

    Consumer<Book> bookDisplayFormat1 = book -> {
        var formatStyle=  String.format("""
                    {
                        Id: %s,
                        Title: %s,
                        Authors: %s,
                        Avge Rating: %s,
                        Isbn: %s
                    }
                """.formatted(book.getId(),book.getTitle(),book.getAuthors()
        ,book.getAvgRating(),book.getIsbn()));
        System.out.println(formatStyle);
    };

    Consumer<Book> bookDisplayFormat2 = book -> {
        var formatStyle=  String.format("""
                    {
                        Id          :   %s,
                        Title       :   %s,
                        Authors     :   %s,
                        Avge Rating :   %s,
                        Isbn        :   %s
                    }
                """.formatted(book.getId(),book.getTitle(),book.getAuthors()
                ,book.getAvgRating(),book.getIsbn()));
        System.out.println(formatStyle);
    };

    public void higherOrderFunction(Book book,Consumer<Book> formatStyle){
        formatStyle.accept(book);
    }

    BiConsumer<Book,Consumer<Book>> biConsumer = (book,formatStyle)->{
            formatStyle.accept(book);
    };

    Function<String, Book> convertToBook = bookStr -> {
      String[] columnArr = bookStr.split(",");
      var i = 0;
     // Book book = new Book()

        Book book = newBook.get();
        book.setId(columnArr[i++]);
        book.setTitle(columnArr[i++]);
        book.setAuthors(columnArr[i++]);
        book.setAvgRating(columnArr[i++]);
        book.setIsbn(columnArr[i++]);

        return book;

    };

    public static int findLengh(String s){
        return s.length();
    }

    Function<String,Integer> strLenFinderV4 = Ex2_Function::findLengh;

    Function<String,Integer> strLenFinderV3 = s -> s.length();



    Function<String,Integer> strLenFinderV2 =(String s) ->{
            return s.length();
        };


    StrLenFinderV1 strLenFinderV1;
    class StrLenFinderV1 implements Function<String,Integer> {

        @Override
        public Integer apply(String s) {
            return s.length();
        }
    }
}
