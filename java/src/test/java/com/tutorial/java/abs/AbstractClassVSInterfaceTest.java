package com.tutorial.java.abs;

import com.tutorial.java.abs.ext.OneToNinePrinter;
import com.tutorial.java.abs.ext.TrianglePrinter;
import com.tutorial.java.abs.impl.OneToNinePrinterImpl;
import com.tutorial.java.abs.impl.TrianglePrinterImpl;
import org.junit.jupiter.api.Test;

class AbstractClassVSInterfaceTest {

    @Test
    void vs() {
        PrinterInterface[] interfaceImpl = {new OneToNinePrinterImpl(), new TrianglePrinterImpl()};
        PrinterAbstractClass[] abstractClass = {new OneToNinePrinter(), new TrianglePrinter()};

        interfaceImpl[0].changeId("ID 변경됨 : OneToNinePrinter 입니다.");
        abstractClass[1].changeId("ID 변경됨 : TrianglePrinter 입니다.");

        System.out.println("====== 추상 클래스 ======");
        for (PrinterAbstractClass abClass : abstractClass) {
            abClass.print();
        }

        System.out.println("\n\n====== 인터페이스 ======");
        for (PrinterInterface impl : interfaceImpl) {
            impl.print();
        }
    }

}