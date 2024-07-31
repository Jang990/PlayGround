package com.tutorial.java.abs.ext;

import com.tutorial.java.abs.PrinterAbstractClass;

public class TrianglePrinter extends PrinterAbstractClass {
    @Override
    public String getPrintResult() {
        return """
                  *
                 ***
                *****
                """;
    }

    @Override
    public void changeId(String id) {
        this.id = id;
    }
}
