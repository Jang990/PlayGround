package com.tutorial.java.problem._369.step4;

import com.tutorial.java.problem._369.step4.rule.Rule369;
import com.tutorial.java.problem._369.step4.rule.dto.Result;

public class Player {
    private String name;
    private double errorRate;

    public Player(String name, double errorRate) {
        this.name = name;
        this.errorRate = errorRate;
    }

    public int play(Rule369 rule, int num) {
        if(isError())
            throw new RuntimeException(name + " 오류 : " + num);

        Result result = rule.apply(num);
        log(rule, result.getResultString());

        return result.getClapCount();
    }

    private boolean isError() {
        return Math.random() * 101 <= errorRate;
    }

    private void log(Rule369 rule, String result) {
        System.out.println("["+rule.getRuleName()+"]" + name + " : " + result);
    }
}
