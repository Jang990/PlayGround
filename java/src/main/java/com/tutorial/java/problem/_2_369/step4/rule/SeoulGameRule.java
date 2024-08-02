package com.tutorial.java.problem._2_369.step4.rule;

import com.tutorial.java.problem._2_369.step3.GameConst;
import com.tutorial.java.problem._2_369.step4.dto.ClapResult;

public class SeoulGameRule implements GameRule {
    private static final String REGION = "Seoul";
    private static final ClapResult CLAP_ONCE = new ClapResult(REGION, GameConst.CLAP_369, 1);

    @Override
    public ClapResult apply(int num) {
        if(has369(num))
            return CLAP_ONCE;
        else
            return new ClapResult(REGION, String.valueOf(num), 0);
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
