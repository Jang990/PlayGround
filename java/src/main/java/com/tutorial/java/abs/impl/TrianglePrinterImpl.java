package com.tutorial.java.abs.impl;

import com.tutorial.java.abs.PrinterInterface;

public class TrianglePrinterImpl implements PrinterInterface {
    private String triangleId = PrinterInterface.DEFAULT_ID;

    @Override
    public String getId() {
        return triangleId;
    }

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
        triangleId = id;
    }
}
