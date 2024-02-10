package com.tutorial.java;

public class OverLoadingRidding {
    static class Parent {
        public void print(int a) {
            System.out.println("Parent.print : " + a);
        }
    }

    static class Child extends Parent {
        @Override
        public void print(int a) {
            System.out.println("Child.print ====> " + a);
        }
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();
        parent.print(10); // Parent.print
        child.print(10); // Child.print

        Parent parentChild = new Child();
        parentChild.print(10); // Child.print
    }
}