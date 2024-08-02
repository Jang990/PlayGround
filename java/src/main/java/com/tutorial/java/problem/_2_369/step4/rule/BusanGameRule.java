package com.tutorial.java.problem._2_369.step4.rule;

import com.tutorial.java.problem._2_369.step3.GameConst;
import com.tutorial.java.problem._2_369.step4.dto.ClapResult;

public class BusanGameRule implements GameRule {
    private static final String REGION = "Busan";

    @Override
    public ClapResult apply(int num) {
        int clapCnt = getClapCnt(num);
        if(clapCnt == 0)
            return new ClapResult(REGION, String.valueOf(num), clapCnt);

        return new ClapResult(REGION, GameConst.CLAP_369.repeat(clapCnt), clapCnt);
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
