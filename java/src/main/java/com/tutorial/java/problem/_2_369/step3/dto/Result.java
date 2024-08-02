package com.tutorial.java.problem._2_369.step3.dto;

public class Result {
    private final String playRegion;
    private final String result;
    private final String playerName;

    public Result(String playRegion, String result, String playerName) {
        this.playRegion = playRegion;
        this.result = result;
        this.playerName = playerName;
    }

    public String getPlayRegion() {
        return playRegion;
    }

    public String getResult() {
        return result;
    }

    public String getPlayerName() {
        return playerName;
    }
}
