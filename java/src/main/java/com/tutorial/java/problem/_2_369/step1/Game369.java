package com.tutorial.java.problem._2_369.step1;

public class Game369 {
    public void start() {
        for (int i = 1; i <= 100; i++) {
            if(has369(i))
                System.out.println("clap");
            else
                System.out.println(i);
        }
    }

    private boolean has369(int target) {
        String targetStr = String.valueOf(target);
        for (int i = 0; i < targetStr.length(); i++) {
            int num = targetStr.charAt(i) - '0';
            if(num != 0 && num % 3 == 0)
                return true;
        }

        return false;
    }
}
