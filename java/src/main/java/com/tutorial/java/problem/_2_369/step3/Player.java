package com.tutorial.java.problem._2_369.step3;

import com.tutorial.java.problem._2_369.step3.dto.Result;
import com.tutorial.java.problem._2_369.step3.rule.GameRule;

public class Player {
    private String name;
    private int errorRate;

    public Player(String name, int errorRate) {
        this.name = name;
        this.errorRate = errorRate;
    }

    public Result play(GameRule rule, int num) {
        if(hasErrorOccurred())
            throw new IllegalStateException();

        return new Result(rule.getRegion(), rule.apply(num), name);
    }

    private boolean hasErrorOccurred() {
        int currentState = (int) (Math.random() * 101);
        return currentState <= errorRate;
    }

    public String getName() {
        return name;
    }
}
