package com.functional.pgming.java.warmup.funcexercisebasic;

import org.apache.commons.lang3.time.StopWatch;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Ex4_Stream {


    Function<List<String>,Long> measureCollectinForEach = books -> {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for(String book: books){
            String[] colArr = book.split(",");
            colArr[0] = "ID#"+colArr[0];
           // System.out.print(colArr[0]);
            //some operation
        }

        stopWatch.stop();
        return stopWatch.getTime(TimeUnit.MILLISECONDS);
    };

    Function<List<String>,Long> measureStreamForEach = books -> {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        books.stream().map(s -> {
            String[] colArr = s.split(",");
            colArr[0] = "ID#"+colArr[0];
            return colArr[0];
        }).count();

        stopWatch.stop();
        return stopWatch.getTime(TimeUnit.MILLISECONDS);
    };

    Function<List<String>,Long> measureParallelStreamForEach = books -> {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        books.parallelStream().map(s -> {
            String[] colArr = s.split(",");
            colArr[0] = "ID#"+colArr[0];
            return colArr[0];
        }).count();


        stopWatch.stop();
        return stopWatch.getTime(TimeUnit.MILLISECONDS);
    };

}
