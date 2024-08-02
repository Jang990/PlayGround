package com.tutorial.java.problem._2_369.step3.rule;

import com.tutorial.java.problem._2_369.step3.GameConst;

public class BusanGameRule implements GameRule {
    private static final String REGION = "Busan";

    @Override
    public String apply(int num) {
        int clapCnt = getClapCnt(num);
        if(clapCnt == 0)
            return String.valueOf(num);

        return GameConst.CLAP_369.repeat(clapCnt);
    }

    @Override
    public String getRegion() {
        return REGION;
    }

    private int getClapCnt(int target) {
        int clapCnt = 0;
        String targetStr = String.valueOf(target);

        for (int i = 0; i < targetStr.length(); i++) {
            int num = targetStr.charAt(i) - '0';
            if (is369(num))
                clapCnt++;
        }

        return clapCnt;
    }

    private boolean is369(int num) {
        return num != 0 && num % 3 == 0;
    }
}
