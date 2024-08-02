package com.tutorial.java.problem._2_369.step4;

import com.tutorial.java.problem._2_369.step4.dto.PlayResult;
import com.tutorial.java.problem._2_369.step4.rule.GameRule;

public class Player {
    private String name;
    private int errorRate;

    public Player(String name, int errorRate) {
        this.name = name;
        this.errorRate = errorRate;
    }

    public PlayResult play(GameRule rule, int num) {
        if(hasErrorOccurred())
            throw new IllegalStateException();

        return new PlayResult(rule.apply(num), name);
    }

    private boolean hasErrorOccurred() {
        int currentState = (int) (Math.random() * 101);
        return currentState <= errorRate;
    }

    public String getName() {
        return name;
    }
}
