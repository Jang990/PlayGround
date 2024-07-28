package com.tutorial.java.problem._369.step4.rule;

import com.tutorial.java.problem._369.step4.rule.dto.Result;

public interface Rule369 {
    /**
     * @return Rule 이름 반환 ex) Seoul, Busan
     */
    String getRuleName();

    /**
     * @param num 33
     * @return 부산의 경우 : {"clapclap", 2} / 서울의 경우 : {"clap", 1}
     */
    Result apply(int num);
}
