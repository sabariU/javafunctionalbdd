package com.functional.pgming.java.warmup.funcexercisebasic.model;
import java.util.function.Consumer;

public class Ex_Consumer {
    public class PrintString implements Consumer<String>{
        @Override
        public void accept(String s){
            System.out.println(s);
        }
    }
}
