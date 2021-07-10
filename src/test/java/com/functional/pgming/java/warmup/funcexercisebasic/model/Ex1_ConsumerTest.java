package com.functional.pgming.java.warmup.funcexercisebasic.model;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.function.Consumer;

@RunWith(JUnit4.class)
public class Ex1_ConsumerTest extends TestCase {

    Ex1_Consumer ex1_consumer;

    @Before
    public void init() {
        ex1_consumer =
                new Ex1_Consumer();
    }
    @Test
    public void testPrintConsumerV1(){
        Ex1_Consumer.PrintStringConsumerV1 printStringConsumerV1 =
                ex1_consumer.new PrintStringConsumerV1();
        printStringConsumerV1.accept("hello world");
    }

    @Test
    public void testPrintConsumerV2(){
        Consumer printStringConsumerV2 = ex1_consumer.printStringConsumerV2;
        ex1_consumer.printStringConsumerV2.accept("lambda");
    }


}