package com.tutorial.java.problem._369.step2;

public class Game369 {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 100;
    public static final String CLAP = "clap";

    private Player[] players;

    public Game369(Player[] players) {
        this.players = players;
    }

    public void start() {
        for (int num = START_NUMBER; num <= END_NUMBER; num++) {
            int playerIdx = (num - START_NUMBER) % players.length;
            players[playerIdx].play(num);
        }
    }
}