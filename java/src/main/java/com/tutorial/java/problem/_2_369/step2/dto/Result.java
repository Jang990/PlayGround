package com.tutorial.java.problem._2_369.step2.dto;

public class Result {
    private final String result;
    private final String playerName;

    public Result(String result, String playerName) {
        this.result = result;
        this.playerName = playerName;
    }

    public String getResult() {
        return result;
    }

    public String getPlayerName() {
        return playerName;
    }
}
