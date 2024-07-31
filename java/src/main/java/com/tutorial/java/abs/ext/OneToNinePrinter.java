package com.tutorial.java.abs.ext;

import com.tutorial.java.abs.PrinterAbstractClass;

public class OneToNinePrinter extends PrinterAbstractClass {
    @Override
    public String getPrintResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 9; i++) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
        return sb.toString();
    }
}
