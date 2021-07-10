package com.functional.pgming.java.warmup;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.function.Consumer;

@RunWith(JUnit4.class)
public class Ex1_ConsumerTest extends TestCase {

    Ex1_Consumer ex1_Consumer;

    @Before
    public void init() {
        ex1_Consumer = new Ex1_Consumer();
    }

    @Test
    public void testPrintConsumerV5(){
        Consumer printStringConsumerV5 = ex1_Consumer.printStringConsumerV5;
        printStringConsumerV5.accept("Got a decent lambda expression");
    }

}