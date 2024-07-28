package com.tutorial.java.problem._369.step3.rule;

import com.tutorial.java.problem._369.step3.Game369;

public class BusanRule369 implements Rule369{
    private static final String RULE_NAME = "Busan";

    public String getRuleName() {
        return RULE_NAME;
    }

    public String apply(int num) {
        int cnt369 = get369Count(num);
        if(cnt369 == 0)
            return String.valueOf(num);

        return Game369.CLAP.repeat(cnt369);
    }

    private int get369Count(int num) {
        String s = String.valueOf(num);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = s.charAt(i) - '0';
            if(is369(current))
                count++;
        }
        return count;
    }

    private boolean is369(int num) {
        return num != 0 && num % 3 == 0;
    }
}
