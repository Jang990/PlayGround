package com.tutorial.java.problem._369.step4.rule;

import com.tutorial.java.problem._369.step4.Game369;
import com.tutorial.java.problem._369.step4.rule.dto.Result;

public class BusanRule369 implements Rule369 {
    private static final String RULE_NAME = "Busan";

    public String getRuleName() {
        return RULE_NAME;
    }

    public Result apply(int num) {
        int cnt369 = get369Count(num);
        if(cnt369 == 0)
            return new Result(String.valueOf(num), cnt369);

        return new Result(Game369.CLAP.repeat(cnt369), cnt369);
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
