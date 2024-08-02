package com.tutorial.java.problem._2_369;


import com.tutorial.java.problem._2_369.step3.Game369;
import com.tutorial.java.problem._2_369.step3.Player;
import com.tutorial.java.problem._2_369.step3.rule.BusanGameRule;
import com.tutorial.java.problem._2_369.step3.rule.GameRule;
import com.tutorial.java.problem._2_369.step3.rule.SeoulGameRule;

/*
3단계 요구사항 - 지역별로 다른 369 룰을 적용하기

지역별 다른 규칙의 적용
- 서울지역에서는 박수를 한번만 침
- 부산 지역에서는 3,6,9가 나온숫자만큼 박수를 쳐야한다.
- 부산 33 => "clapclap", 서울 33 => "clap"

로그를 찍을 때 지역도 찍어주기
 [Seoul] 현우 : clap
 [Seoul] 민우 : 25
이런식으로 앞에 지역을 출력해줄 것.
 */
public class Main369_3 {
    public static void main(String[] args) {
        Player[] players = {
                new Player("현우", 1),
                new Player("영주", 1),
                new Player("민수", 1),
                new Player("정환", 1)
        };
        System.out.println("====== Seoul ======");
        Game369 seoulGame = new Game369(players, new SeoulGameRule());
        seoulGame.start();

        System.out.println("====== Busan ======");

        Game369 busanGame = new Game369(players, new BusanGameRule());
        busanGame.start();
    }
}
