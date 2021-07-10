package com.functional.pgming.java.warmup.funcexercisebasic.model;

import java.util.List;
import java.util.function.Consumer;

public class Ex1_Consumer {
    private int stateValue;
    public String name = "hello";
    public Consumer<List<String>> printStringConsumerV2 = s -> {
        for(String item: s){
            System.out.println(item);
        }
    };

    public class PrintStringConsumerV1 implements Consumer<String> {

        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    }

}
