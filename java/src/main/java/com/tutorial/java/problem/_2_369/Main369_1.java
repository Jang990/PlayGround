package com.tutorial.java.problem._2_369;


import com.tutorial.java.problem._2_369.step1.Game369;

/*
 1단계 요구사항. - 기본 369 게임 구성하기
문자열에서 3, 6, 9 라는 숫자를 갖는지 체크
있으면 clap 반환, 없으면 숫자 문자형태로 반환
숫자 1에서 시작하고 100번까지 진행한다.
 */
public class Main369_1 {
    public static void main(String[] args) {
        Game369 game = new Game369();
        game.start();
    }
}
