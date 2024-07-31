package com.tutorial.java.abs;

// 기능 확장
public abstract class PrinterAbstractClass {
    protected String id = "Abstract를 구현"; // 공통 필드 사용 - 하위에서 변경 가능함

    public abstract String getPrintResult();

    public void changeId(String id) {
        this.id = id;
    }

    public void print() {
        System.out.println(id);
        System.out.println(getPrintResult());
    }

    // 접근 제어자 제약 없음
    private void myPrivateMethod() {}
    protected void myProtectedMethod() {}
    void myDefaultMethod() {}
}
