package com.tutorial.java.spring;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld implements Printer {
    @Override
    public void print() {
        System.out.println(this.getClass().getName() + " : " + "Hello World!");
    }
}
