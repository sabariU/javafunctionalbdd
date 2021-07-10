package com.functional.pgming.java.warmup.funcexercisebasic;

import java.util.function.Function;

public class Ex2_Function {


    public Function<String,Integer> strLenFinderV3 =
            myString -> myString.length();


    public Function<String,Integer> strLenFinderV2 = (myString) -> {
            return myString.length();
    };


    public class StrLenFinderV1 implements Function<String,Integer>{

        @Override
        public Integer apply(String s) {
            return s.length();
        }
    }

}
