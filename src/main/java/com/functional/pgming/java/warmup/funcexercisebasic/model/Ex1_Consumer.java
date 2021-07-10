package com.functional.pgming.java.warmup.funcexercisebasic.model;

import java.util.function.Consumer;

public class Ex1_Consumer {
    private int stateValue;
    public String name = "hello";
    public Consumer<String> printStringConsumerV2 = s -> System.out.println(s);

    public class PrintStringConsumerV1 implements Consumer<String> {

        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    }

}
