package com.tutorial.java.abs;

// 기능 공통화
public interface PrinterInterface {
    /* public static final */ String DEFAULT_ID = "Interface를 구현"; // 변수 변경 불가능(psf 기본적용)
    // String something; // 불가능

    /* public abstract */ String getId(); // public abstract 기본 적용

    String getPrintResult();

    void changeId(String id);

    // 하위 구현체들에게 공통의 기능을 쉽게 제공하기 위한 default 메소드(구현체에서 필요 시 오버라이딩) - java 8부터 가능
    default void print() {
        System.out.println(getId());
        System.out.println(getPrintResult());
    }

    // private 접근제어자는 가능(인터페이스 내부 기능 캡슐화를 위함) - java 9부터 가능
    private void myPrivateMethod() { getId(); }

    // protected, 디폴트 접근 제어자는 사용 불가능
//    protected void myProtectedMethod() {}
//    void myDefaultMethod() {}
    // 이것도 불가능
//    protected static void doSomethingProtected() {}

    public static void doSomething() {
        System.out.println("doSomething");
    }
}
