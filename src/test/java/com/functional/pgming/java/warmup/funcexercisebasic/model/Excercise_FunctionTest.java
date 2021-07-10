package com.functional.pgming.java.warmup.funcexercisebasic.model;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@RunWith(JUnit4.class)
public class Excercise_FunctionTest extends TestCase {

    Excercise_Function ex1_consumer;
    List<String> bookList;

    @Before
    public void init() {
        ex1_consumer = new Excercise_Function();
        bookList = new ArrayList<String>(
                Arrays.asList("1576,The Wasps,Aristophanes/David B. Barrett,3.94,0140441522",
                        "1577,Four Comedies: Lysistrata / The Frogs / The Birds / Ladies' Day,Aristophanes/Dudley Fitts,4.03,0156027658",
                        "1579,Frogs/Assemblywomen/Wealth (Loeb Classical Library 180),Aristophanes/Jeffrey Henderson,4.21,0674995961",
                        "1584,Cliffs Notes on Aristophanes' Lysistrata  The Birds  The Clouds  The Frogs,W. John Campbell,2.80,0822007762",
                        "1585,Aristophanes and Athens: An Introduction to the Plays,Douglas M. MacDowell,4.07,0198721595",
                        "1586,Lysistrata,Aristophanes/Douglass Parker,3.85,0451616227",
                        "1590,Peace,Aristophanes/S. Douglas Olson,3.60,0198140819",
                        "1591,Lysistrata,Aristophanes/Sarah Ruden,3.85,0872206033",
                        "1592,The Knights / Peace / The Birds / The Assembly Women / Wealth,Aristophanes/Alan H. Sommerstein/David B. Barrett/David Brett,3.69,0140443320",
                        "1595,Genres in Dialogue: Plato and the Construct of Philosophy,Andrea Wilson Nightingale,4.33,0521774330",
                        "1618,The Curious Incident of the Dog in the Night-Time,Mark Haddon,3.88,1400032717",
                        "1620,The Night Gardener,George Pelecanos,3.64,0316156507",
                        "1625,Twelfth Night,William Shakespeare,3.98,0743482778"));
    }

    @Test
    public void convertBook(){
        Function<String,Book> convertBook = ex1_consumer.convertBook;

        for(String bookStr:bookList){
            Book book = convertBook.apply(bookStr);
            var textBlock = """
                         {
                          Id          :   %s,
                          Title       :   %s,
                          Authors     :   %s,
                          Avge Rating :   %s,
                          Isbn        :   %s
                         }
                        """;

            System.out.println(String.format(textBlock,book.getId(), book.getTitle(), book.getAuthors(),
                    book.getAvgRating(), book.getIsbn()));
        }


    }

}