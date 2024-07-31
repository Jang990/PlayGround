package com.tutorial.java.abs.impl;

import com.tutorial.java.abs.PrinterInterface;

public class OneToNinePrinterImpl implements PrinterInterface {
    private String oneToNineId = PrinterInterface.DEFAULT_ID;

    @Override
    public String getId() {
        return oneToNineId;
    }

    @Override
    public String getPrintResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 9; i++) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public void changeId(String id) {
        oneToNineId = id;
    }
}
