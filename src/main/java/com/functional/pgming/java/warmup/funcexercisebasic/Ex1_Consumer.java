package com.functional.pgming.java.warmup.funcexercisebasic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.JsonUtils;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Ex1_Consumer {

    Consumer<List<String>> printColors = colors -> {
        for(var color: colors){
            System.out.println(color);
        }
    };

    Consumer<List<String>> toUpper = colors ->{
        var i = new AtomicInteger(-1);
        for(var color: colors){
           colors.set(i.incrementAndGet(),color.toUpperCase());
        }
    };

    Consumer<String> printStringV6 = s -> {
        System.out.println(s.toUpperCase()+" (::)");
    };

    Consumer<String> printStringV5 = s -> {
        System.out.println(s);
    };

    Consumer<String> printStringV4 = s -> {
        System.out.println(s);
    };


    Consumer<String> printStringV3 = (String s) -> {
            System.out.println(s);
    };

    Consumer printStringV2 = new Consumer<String>(){

        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    };

    PrintStringV1 printStringV1;
    public class PrintStringV1 implements Consumer<String>{

        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    }



}
