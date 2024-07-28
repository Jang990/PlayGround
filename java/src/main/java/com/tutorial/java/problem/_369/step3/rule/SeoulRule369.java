package com.tutorial.java.problem._369.step3.rule;

import com.tutorial.java.problem._369.step3.Game369;

public class SeoulRule369 implements Rule369{
    private static final String RULE_NAME = "Seoul";

    public String getRuleName() {
        return RULE_NAME;
    }

    public String apply(int num) {
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

    private boolean is369(int num) {
        return num != 0 && num % 3 == 0;
    }
}
