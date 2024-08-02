package com.tutorial.java.problem._2_369.step4.dto;

public class ClapResult {
    private final String region;
    private final String result;
    private final int clapCnt;

    public ClapResult(String region, String result, int clapCnt) {
        this.region = region;
        this.result = result;
        this.clapCnt = clapCnt;
    }

    public boolean isClap() {
        return clapCnt > 0;
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
}
