package com.tutorial.java.problem._2_369.step4.dto;

public class PlayResult {
    private final String region;
    private final String result;
    private final int clapCnt;
    private final String playerName;

    public PlayResult(ClapResult clapResult, String playerName) {
        this.region = clapResult.getRegion();
        this.result = clapResult.getResult();
        this.clapCnt = clapResult.getClapCnt();
        this.playerName = playerName;
    }

    public String getRegion() {
        return region;
    }

    public String getResult() {
        return result;
    }

    public int getClapCnt() {
        return clapCnt;
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean isClap() {
        return clapCnt > 0;
    }
}
