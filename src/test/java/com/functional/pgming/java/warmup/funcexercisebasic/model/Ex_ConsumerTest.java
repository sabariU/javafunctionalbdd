package com.functional.pgming.java.warmup.funcexercisebasic.model;

import junit.framework.TestCase;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class Ex_ConsumerTest extends TestCase {
    Ex_Consumer  ex1_consumer;
    @Before
    public void init() {
        ex1_consumer =
                new Ex_Consumer();
    }



    @Test
    public void consumertest(){

        Ex_Consumer.PrintString implConsumer = ex1_consumer.new PrintString();

        implConsumer.accept("Hello World");


    }

}