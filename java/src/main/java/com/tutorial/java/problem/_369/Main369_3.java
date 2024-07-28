package com.tutorial.java.problem._369;


import com.tutorial.java.problem._369.step3.Game369;
import com.tutorial.java.problem._369.step3.Player;
import com.tutorial.java.problem._369.step3.rule.BusanRule369;
import com.tutorial.java.problem._369.step3.rule.SeoulRule369;

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
                new Player("현우", 0),
                new Player("영주", 0),
                new Player("민수", 0),
                new Player("정환", 0)
        };

        Game369 game = new Game369(players, new SeoulRule369());
        game.start();

        System.out.println();

        game.changeRule(new BusanRule369());
        game.start();
    }
}
