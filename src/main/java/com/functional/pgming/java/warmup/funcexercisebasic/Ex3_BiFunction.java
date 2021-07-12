package com.functional.pgming.java.warmup.funcexercisebasic;

import com.functional.pgming.java.warmup.funcexercisebasic.model.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Ex3_BiFunction {

    Supplier<Ex2_Function> ex2_functionSupplier = Ex2_Function::new;

    Ex2_Function ex2_function;

    Supplier<Map<String, Book>> newBookMapSupplier = HashMap::new;

    BiConsumer<String,Map<String,Book>> printParitcularBook = (key,bookMap) -> {
          Book book = bookMap.get(key);
        ex2_function = ex2_functionSupplier.get();
          ex2_function.higherOrderFunction(book,
                ex2_function.bookDisplayFormat2);
    };




    Function<List<Book>, Map<String, Book>> convertBookListToMap =
            books -> {
                Map<String, Book> bookMap = newBookMapSupplier.get();
                for (Book book : books) {
                    bookMap.put(book.getId(), book);
                }
                return bookMap;
            };
}
