package com.tutorial.java.spring;

import org.springframework.stereotype.Component;

@Component
public class DoSomething implements Printer {
    @Override
    public void print() {
        System.out.println(this.getClass().getName() + " : " + "Do Something");
    }
}
