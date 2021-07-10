package com.functional.pgming.java.warmup.funcexercisebasic.model;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Ex2_FunctionTest extends TestCase {
    Ex2_Function ex2_function;

    @Before
    public void init() {
        ex2_function =
                new Ex2_Function();
    }

    @Test
    public  void  testStrlen(){
        Ex2_Function.Strlenfinder strlenfinder = ex2_function.new Strlenfinder();
        Integer length = strlenfinder.apply("hello world");
        Integer expectedLength = 11;
        Assert.assertEquals(length, expectedLength);
    }

}