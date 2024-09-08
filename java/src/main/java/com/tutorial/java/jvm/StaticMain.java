package com.tutorial.java.jvm;

public class StaticMain {
    public static void main(String[] args) {
        /*
        java -verbose:class StaticMain.java

        ======= START =======
        100
        [0.937s][info][class,load] com.tutorial.java.jvm.StaticMain$MyStaticConst source: file:/C:/Java_WS/PlayGround/java/src/main/java/com/tutorial/java/jvm/StaticMain.java
        com.tutorial.java.jvm.StaticMain$MyStaticConst@70beb599
        ==> Created MyStaticConst Object
        ======= END =======
         */
        System.out.println("======= START =======");

        System.out.println(MyStaticConst.MY_NUM);
        System.out.println(new MyStaticConst());
        System.out.println("==> Created MyStaticConst Object");

        System.out.println("======= END =======");
    }

    static class MyStaticConst {
        static final int MY_NUM = 100;
    }
}
