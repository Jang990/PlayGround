package com.tutorial.java.problem._369.step4;

import com.tutorial.java.problem._369.step4.rule.Rule369;

public class Game369 {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 100;
    public static final String CLAP = "clap";

    private Player[] players;
    private Rule369 rule;
    private ClapCounter clapCounter;

    public Game369(Player[] players, Rule369 rule, ClapCounter counter) {
        this.players = players;
        this.rule = rule;
        this.clapCounter = counter;
    }

    public void start() {
        for (int num = START_NUMBER; num <= END_NUMBER; num++) {
            int playerIdx = (num - START_NUMBER) % players.length;
            int clapCount = players[playerIdx].play(rule, num);
            clapCounter.increase(clapCount);
        }
    }
}