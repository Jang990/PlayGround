package com.tutorial.java.problem._369;

/*
 1단계 요구사항. - 기본 369 게임 구성하기
문자열에서 3, 6, 9 라는 숫자를 갖는지 체크
있으면 clap 반환, 없으면 숫자 문자형태로 반환
숫자 1에서 시작하고 100번까지 진행한다.
 */
public class Main369_1 {
    public static void main(String[] args) {
        Game369 game = new Game369();
        game.play();

//        System.out.println();
//        System.out.println("861 ===> "+ game.has369(861));
//        System.out.println("851 ===> "+ game.has369(851));
    }

    static class Game369 {
        private static final int START_NUMBER = 1;
        private static final int END_NUMBER = 100;

        public void play() {
            for (int num = START_NUMBER; num <= END_NUMBER; num++) {
                if(has369(num))
                    System.out.println("clap");
                else
                    System.out.println(num);
            }
        }

        public boolean has369(int num) {
            String s = String.valueOf(num);
            for (int i = 0; i < s.length(); i++) {
                int current = s.charAt(i) - '0';
                if(current % 3 == 0)
                    return true;
            }
            return false;
        }
    }
}
