package com.tutorial.java._sealed;

import com.tutorial.java._sealed._class.ParentSealedClass;
import com.tutorial.java._sealed._interface.ParentSealedInterface;

public class Main {
    public static void main(String[] args) {
        // FinalClass, NonSealedClass, SealedClass만 permits에 들어갈 수 있음
        ParentSealedClass parentClass = new ParentSealedClass();

        // 인터페이스이기 때문에 NonSealedInterface, SealedInterface
        // 인터페이스는 레코드 타입도 가능 - MyRecord
        ParentSealedInterface parentInterface;

        // 같은 패키지가 아니라면 sealed 클래스(인터페이스)를 상속받을 수 없음
        WrongClass wrongClass = new WrongClass();
    }
}
