package com.tutorial.java.problem._369.step1;

public class Game369 {
        private static final int START_NUMBER = 1;
        private static final int END_NUMBER = 100;

        public void play() {
            for (int num = START_NUMBER; num <= END_NUMBER; num++) {
                if(has369(num))
                    System.out.println("clap");
                else
                    System.out.println(num);
            }
        }

        public boolean has369(int num) {
            String s = String.valueOf(num);
            for (int i = 0; i < s.length(); i++) {
                int current = s.charAt(i) - '0';
                if(current % 3 == 0)
                    return true;
            }
            return false;
        }
    }