package com.tutorial.java.sort;

import com.tutorial.java.ArrayPrinter;

public class Main {
    public static void main(String[] args) {
        int[] bubble = {1, 3, 5, 2, 4};
        Sort.bubble(bubble);
        ArrayPrinter.print(bubble);

        int[] select = {1, 3, 5, 2, 4};
        Sort.select(select);
        ArrayPrinter.print(select);
    }
}
