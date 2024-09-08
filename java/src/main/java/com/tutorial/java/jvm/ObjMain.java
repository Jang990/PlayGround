package com.tutorial.java.jvm;

public class ObjMain {
    /*
    java -verbose:class ObjMain.java

    ======= START =======
    [0.662s][info][class,load] java.lang.invoke.LambdaForm$MH/0x0000023e23134800 source: __JVM_LookupDefineClass__
    --> Created String Object My String
    [0.662s][info][class,load] com.tutorial.java.jvm.Main$Hello source: file:/C:/Java_WS/PlayGround/java/src/main/java/com/tutorial/java/jvm/Main.java
    --> Created Hello Object
    --> Hello
    --> Hello
    ======= END =======
     */
    public static void main(String[] args) {
        System.out.println("======= START =======");
        String str = "My String";
        System.out.println("--> Created String Object " + str);

        Hello hello = new Hello();
        System.out.println("--> Created Hello Object");
        hello.hello();
        hello.hello();

        System.out.println("======= END =======");
    }

    static class Hello {
        public void hello() {
            System.out.println("--> Hello");
        }
    }

}
