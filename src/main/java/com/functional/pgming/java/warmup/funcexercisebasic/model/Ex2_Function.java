package com.functional.pgming.java.warmup.funcexercisebasic.model;

import java.util.function.Function;

public class Ex2_Function {

    public Function<String, Integer> strlenfinderLambda = (s)-> s.length();


    public class Strlenfinder implements Function<String, Integer>{

        @Override
        public Integer apply(String s) {
            return s.length();
        }
    }
}
