package com.functional.pgming.java.warmup.funcexercisebasic.model;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class Ex1_ConsumerTest extends TestCase {

    Ex1_Consumer ex1_consumer;

    @Before
    public void init() {
        ex1_consumer =
                new Ex1_Consumer();
    }

    @Test
    public void printArray(){
        var members = Arrays.asList("red","green","blue","yellow","orange");
        var manipulateConsumer = ex1_consumer.toUpper;
        var displayConsumer = ex1_consumer.printColors;

        manipulateConsumer.andThen(displayConsumer).accept(members);
    }

    @Test
    public void combineV5V6(){
        var consumerV5 = ex1_consumer.printStringV5;
        var consumerV6 = ex1_consumer.printStringV6;

        consumerV5.andThen(consumerV6).accept("Accept your new destiny happily");
    }

    @Test
    public void testConsumerV4(){
        var consumerV4 = ex1_consumer.printStringV4;
        consumerV4.accept("Accept your new destiny happily");
    }

    @Test
    public void testConsumerV3(){
        var consumerV3 = ex1_consumer.printStringV3;
        consumerV3.accept("Accept your new destiny with a good mood");
    }

    @Test
    public void testConsumerV2(){
        var consumerV2 = ex1_consumer.printStringV2;
        consumerV2.accept("Accept your new destiny");
    }

    @Test
    public void testConsumerV1(){

        Ex1_Consumer.PrintStringV1 printStringV1
                = new Ex1_Consumer().new PrintStringV1();

        printStringV1.accept("Accept your destiny");

        List<String> days = Arrays.asList("Mon","Tue","Thu","Fri");

        for(String day: days){
            printStringV1.accept(day);
        }
    }

}