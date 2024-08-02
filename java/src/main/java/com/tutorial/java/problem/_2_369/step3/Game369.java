package com.tutorial.java.problem._2_369.step3;

import com.tutorial.java.problem._2_369.step3.dto.Result;
import com.tutorial.java.problem._2_369.step3.rule.GameRule;

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
                GameLogger.info(currentPlayer.play(rule, num));
            } catch (IllegalStateException e) {
                GameLogger.error(currentPlayer);
                return;
            }
        }
    }
}
