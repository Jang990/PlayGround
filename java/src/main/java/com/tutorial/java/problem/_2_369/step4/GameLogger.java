package com.tutorial.java.problem._2_369.step4;

import com.tutorial.java.problem._2_369.step4.dto.PlayResult;

public class GameLogger {
    public static void info(PlayResult result) {
        String content = String.format("[%s] %s : %s", result.getRegion(), result.getPlayerName(), result.getResult());
        log(content);
    }

    public static void error(Player player) {
        String content = String.format("%s : 오류발생", player.getName());
        log(content);
    }

    public static void info(ClapCounter clapCounter) {
        String content = String.format("모든 게임 박수 횟수 : %d", clapCounter.getClapCount());
        log(content);
    }

    private static void log(String content) {
        System.out.println(content);
    }
}
