package com.tutorial.java.problem._369.step3;

import com.tutorial.java.problem._369.step3.rule.Rule369;

public class Game369 {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 100;
    public static final String CLAP = "clap";

    private Player[] players;
    private Rule369 rule;

    public Game369(Player[] players, Rule369 rule) {
        this.players = players;
        changeRule(rule);
    }

    public void start() {
        for (int num = START_NUMBER; num <= END_NUMBER; num++) {
            int playerIdx = (num - START_NUMBER) % players.length;
            players[playerIdx].play(rule, num);
        }
    }

    public void changeRule(Rule369 rule) {
        this.rule = rule;
    }
}