package com.tutorial.java.problem._2_369;

import com.tutorial.java.problem._2_369.step4.ClapCounter;
import com.tutorial.java.problem._2_369.step4.Game369;
import com.tutorial.java.problem._2_369.step4.GameLogger;
import com.tutorial.java.problem._2_369.step4.Player;
import com.tutorial.java.problem._2_369.step4.rule.BusanGameRule;
import com.tutorial.java.problem._2_369.step4.rule.SeoulGameRule;

/*
4단계 요구사항 - 동시 실행하기

여러 지역의 게임을 동시에 진행하기. 멀티 스레드 진행

여러 지역의 게임을 동시에 진행면서 나오는 박수 횟수를 계산하고
마지막에 총 박수 횟수를 출력하기
 모든 game의 박수 횟수: 39
 이런식으로 마지막에 출력
 */
public class Main369_4 {
    public static void main(String[] args) throws InterruptedException {
        Player[] players = {
                new Player("현우", 0),
                new Player("영주", 0),
                new Player("민수", 0),
                new Player("정환", 0)
        };

        ClapCounter clapCounter = new ClapCounter();
        Game369 seoulGame = new Game369(players, new SeoulGameRule(), clapCounter);
        Game369 busanGame = new Game369(players, new BusanGameRule(), clapCounter);

        Thread t1 = new Thread(seoulGame::start);
        Thread t2 = new Thread(busanGame::start);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        GameLogger.info(clapCounter);
    }
}
