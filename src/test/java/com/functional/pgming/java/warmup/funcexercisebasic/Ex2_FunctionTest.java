package com.functional.pgming.java.warmup.funcexercisebasic;

import com.functional.pgming.java.warmup.funcexercisebasic.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Ex2_FunctionTest {

    Ex2_Function ex2_function;
    @Before
    public void setUp() throws Exception {
        ex2_function = new Ex2_Function();


    }

    @Test
    public void covertToBook(){
        var bookList = new ArrayList<>(
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


        for(String bkStr : bookList){
            Book book = ex2_function.convertToBook.apply(bkStr);
            //ex2_function.higherOrderFunction(book,ex2_function.bookDisplayFormat2);
            ex2_function.biConsumer.accept(book,ex2_function.bookDisplayFormat2);
        }

       // lst.forEach((e)->System.out.println(e));

    }

    @Test
    public void testMethodReference(){
        var strLenFinderV4 =
                ex2_function.strLenFinderV4;

        var result = strLenFinderV4.apply("123456789");
        System.out.println(result);

    }

    @Test
    public void testStrLenFinderV3(){
        var strLenFinderV3 =
                ex2_function.strLenFinderV3;

        var result = strLenFinderV3.apply("123456789");

        System.out.println(result);

    }

    @Test
    public void testStrLenFinderV1(){
        Ex2_Function.StrLenFinderV1 strLenFinderV1 =
                ex2_function.new StrLenFinderV1();

        var result = strLenFinderV1.apply("123456789");

        System.out.println(result);

    }


}