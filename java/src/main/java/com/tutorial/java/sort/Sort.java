package com.tutorial.java.sort;

public class Sort {
    public static void select(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[minIdx] > arr[j]) minIdx = j;
            }
            swap(arr, i, minIdx);
        }
    }

    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j - 1] < arr[j]) continue;
                swap(arr, j, j-1);
            }
        }
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx2];
        arr[idx2] = arr[idx1];
        arr[idx1] = temp;
    }
}
