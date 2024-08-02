package com.tutorial.java.problem._2_369.step2;

public class GameRule {
    public String apply(int num) {
        if(has369(num))
            return "clap";
        else
            return String.valueOf(num);
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
