package com.tutorial.java.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PrinterTest {
    @Autowired Printer doSomething;
    @Autowired Printer helloWorld;

//    @Autowired Printer printer; // 스프링 구성 중 UnsatisfiedDependencyException 발생

    @Test
    void test() {
        helloWorld.print(); // com.tutorial.java.spring.HelloWorld : Hello World!
        doSomething.print(); // com.tutorial.java.spring.DoSomething : Do Something
    }

}