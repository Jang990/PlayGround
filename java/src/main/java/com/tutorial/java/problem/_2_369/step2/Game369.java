package com.tutorial.java.problem._2_369.step2;

import com.tutorial.java.problem._2_369.step2.dto.Result;

public class Game369 {
    private Player[] players;
    private GameRule rule;

    public Game369(Player[] players, GameRule rule) {
        this.players = players;
        this.rule = rule;
    }

    public void start() {
        for (int num = 1; num <= 100; num++) {
            int currentPlayerIdx = (num - 1) % players.length;
            Player currentPlayer = players[currentPlayerIdx];

            try {
                play(currentPlayer, num);
            } catch (IllegalStateException e) {
                GameLogger.error(currentPlayer);
                return;
            }
        }
    }

    private void play(Player player, int num) {
        Result result = player.play(rule, num);
        GameLogger.info(result);
    }
}
