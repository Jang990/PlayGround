package com.tutorial.java.problem._2_369;

import com.tutorial.java.problem._2_369.step2.Game369;
import com.tutorial.java.problem._2_369.step2.GameRule;
import com.tutorial.java.problem._2_369.step2.Player;

/*
2단계 요구사항 - 게임을 진행하는 이름과 오답률을 가지고 있는 클래스 추가하기

여러 사용자가 있음. -> 만약 4명의 사용자라면 4명의 사용자가 순서대로 돌아가면서 게임을 진행함.
 현우 : 1
 영주 : 2
 민수 : clap
 정환 : 4
 현우 : 5

각 플레이어는 오답률에 의해서 잘못된 답을 말할 확률이 있음.
 현우 : 1
 우민 : 2
 // 민수 : 에러 출력없이 바로 게임 종료.
 */
public class Main369_2 {
    public static void main(String[] args) {
        Player[] players = {
                new Player("현우", 1),
                new Player("영주", 3),
                new Player("민수", 5),
                new Player("정환", 7)
        };
        GameRule rule = new GameRule();
        Game369 game = new Game369(players, rule);

        game.start();
    }
}
