package com.tutorial.java;

import java.util.HashMap;
import java.util.Hashtable;

public class HashMapVSHashTable {
    public static void main(String[] args) {
        /*
        Thread-Safe X
        null 가능
        버킷에 노드가 8개 이상 들어오면 균형 BST의 일종인 red black tree로 전환. logn을 보장
            - (구현 내부에 TREEIFY_THRESHOLD 변수 확인해보기)
         */
        HashMap map = new HashMap();

        /*
        Thread-Safe
        null 불가능
        충돌이 발생해도 그냥 list 형식이라 최악의 경우 n의 시간복잡도
         */
        Hashtable table = new Hashtable();

    }
}
