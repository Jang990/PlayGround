package com.tutorial.java.problem._2_369.step3.rule;

import com.tutorial.java.problem._2_369.step3.GameConst;
import com.tutorial.java.problem._2_369.step3.rule.GameRule;

public class SeoulGameRule implements GameRule {
    private static final String REGION = "Seoul";

    @Override
    public String apply(int num) {
        if(has369(num))
            return GameConst.CLAP_369;
        else
            return String.valueOf(num);
    }

    @Override
    public String getRegion() {
        return REGION;
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
