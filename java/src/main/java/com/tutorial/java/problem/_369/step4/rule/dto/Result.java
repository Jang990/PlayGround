package com.tutorial.java.problem._369.step4.rule.dto;

public class Result {
    private final String result;
    private final int clapCount;

    public Result(String result, int clapCount) {
        this.result = result;
        this.clapCount = clapCount;
    }

    public String getResultString() {
        return result;
    }

    public int getClapCount() {
        return clapCount;
    }
}
