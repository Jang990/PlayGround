package com.tutorial.java.problem._2_369.step3;

import com.tutorial.java.problem._2_369.step3.dto.Result;

public class GameLogger {
    public static void info(Result result) {
        String content = String.format("[%s] %s : %s", result.getPlayRegion(), result.getPlayerName(), result.getResult());
        log(content);
    }

    public static void error(Player player) {
        String content = String.format("%s : 오류발생", player.getName());
        log(content);
    }

    private static void log(String content) {
        System.out.println(content);
    }
}
