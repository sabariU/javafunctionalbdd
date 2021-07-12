package com.functional.pgming.java.warmup.funcexercisebasic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RunWith(JUnit4.class)
public class Ex4_StreamTest {


    Ex4_Stream ex4_stream;
    @Before
    public void setUp() throws Exception {
        ex4_stream = new Ex4_Stream();
    }

    @Test
    public void covertToBook(){
        List<String> bookList = new ArrayList();


        final var loadSize = 10000000;

        IntStream.rangeClosed(1,loadSize).forEach(i->
                bookList.add(
                "1576%d,Test Title,3.94,0140441522".formatted(i)));

        System.out.println("Go..");

       Long elapseTime1 =   ex4_stream.measureCollectinForEach.apply(bookList);

       Long elapseTime2 = ex4_stream.measureStreamForEach.apply(bookList);

       Long elapseTime3 = ex4_stream.measureParallelStreamForEach.apply(bookList);

        var result =
        """
              {
                Load size : %d
                Collection.forEach in milliseconds : %d
                Stream.forEach in milliseconds : %d
                ParallelStream.forEach in milliseconds : %d
              }
                """.formatted(loadSize,elapseTime1,elapseTime2,elapseTime3);

        System.out.println(result);

    }

}