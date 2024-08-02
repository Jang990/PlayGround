package com.tutorial.java.problem._2_369.step4;

import com.tutorial.java.problem._2_369.step4.dto.PlayResult;
import com.tutorial.java.problem._2_369.step4.rule.GameRule;

public class Game369 {
    private Player[] players;
    private GameRule rule;
    private ClapCounter clapCounter;

    public Game369(Player[] players, GameRule rule, ClapCounter clapCounter) {
        this.players = players;
        this.rule = rule;
        this.clapCounter = clapCounter;
    }

    public void start() {
        for (int num = 1; num <= 100; num++) {
            int currentPlayerIdx = (num - 1) % players.length;
            Player currentPlayer = players[currentPlayerIdx];

            try {
                play(num, currentPlayer);
            } catch (IllegalStateException e) {
                GameLogger.error(currentPlayer);
                return;
            }
        }
    }

    private void play(int num, Player currentPlayer) {
        PlayResult result = currentPlayer.play(rule, num);
        if(result.isClap())
            clapCounter.increase(result.getClapCnt());
        GameLogger.info(result);
    }
}
