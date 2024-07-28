package com.tutorial.java.problem._369.step3.rule;

public interface Rule369 {
    /**
     * @return Rule 이름 반환 ex) Seoul, Busan
     */
    String getRuleName();

    /**
     * @param num 33
     * @return 부산의 경우 : "clapclap" / 서울의 경우 : "clap"
     */
    String apply(int num);
}
