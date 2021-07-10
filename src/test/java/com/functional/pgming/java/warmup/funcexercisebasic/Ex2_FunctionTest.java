package com.functional.pgming.java.warmup.funcexercisebasic;

import io.cucumber.java.sl.In;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.function.Function;

@RunWith(JUnit4.class)
public class Ex2_FunctionTest extends TestCase {

    Ex2_Function ex2_function;
    @Before
    public void init() {
        ex2_function =
                new Ex2_Function();
    }

    @Test
    public void testStrLenFinderV3(){
        Function<String,Integer> strLenFinderV3 =
                ex2_function.strLenFinderV3;
        var testData = "123456789";
        var result = strLenFinderV3.apply(testData);
        Integer expectedResult = 9;

        Assert.assertEquals(expectedResult,result);

    }

    @Test
    public void testStrLenFinderV1(){
        var strLenFinderV1 =
                ex2_function.new StrLenFinderV1();
        var actualResult = strLenFinderV1.apply("123456789");

        Integer expectedResultPostive = 9;

        System.out.println("Result : " + actualResult);

        Assert.assertEquals(expectedResultPostive,actualResult);

        Integer expectedResultNegative = 19;
        Assert.assertNotEquals(expectedResultNegative,actualResult);

    }
}