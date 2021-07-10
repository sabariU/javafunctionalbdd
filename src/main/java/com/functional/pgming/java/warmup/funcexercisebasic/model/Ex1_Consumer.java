package com.functional.pgming.java.warmup.funcexercisebasic.model;

import java.util.function.Consumer;

public class Ex1_Consumer {

    private String s1 = "str1" ;

    public Consumer<String> printStringConsumerV5 = s ->  System.out.println(s);

    public Consumer<String> printStringConsumerV4 = (s) -> {
        System.out.println(s);
    };

    public Consumer<String> printStringConsumerV3 = (String s) -> {
        System.out.println(s);
    };

    public Consumer PrintStringConsumerV2 = new Consumer<String>() {
        @Override
        public void accept(String s) {
            System.out.println(s);
        }


    };

    public class PrintStringConsumerV1 implements Consumer<String> {
        @Override
        public void accept(String s) {
            System.out.println(s);
        }

    }

}
