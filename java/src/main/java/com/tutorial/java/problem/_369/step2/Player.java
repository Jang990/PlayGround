package com.tutorial.java.problem._369.step2;

public class Player {
    private String name;
    private double errorRate;

    public Player(String name, double errorRate) {
        this.name = name;
        this.errorRate = errorRate;
    }

    public void play(int num) {
        if(isError())
            throw new RuntimeException(name + " 오류 : " + num);

        String result = process(num);
        log(result);
    }

    private String process(int num) {
        if(has369(num))
            return Game369.CLAP;
        else
            return String.valueOf(num);
    }

    private boolean has369(int num) {
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            int current = s.charAt(i) - '0';
            if(is369(current))
                return true;
        }
        return false;
    }

    private boolean isError() {
        return Math.random() * 101 <= errorRate;
    }

    private void log(String result) {
        System.out.println(name + " : " + result);
    }

    private boolean is369(int num) {
        return num != 0 && num % 3 == 0;
    }
}
