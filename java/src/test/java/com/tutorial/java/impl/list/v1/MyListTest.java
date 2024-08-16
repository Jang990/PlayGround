package com.tutorial.java.impl.list.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MyListTest {

    private MyList<Integer> list;
    private final int[] INSTANCE = {236, 10012, 5465};
    final String[] STRING_INSTANCE = {"A", "B", "C"};

    @BeforeEach
    void beforeEach() {
        list = new MyList<>();
        list.add(INSTANCE[0]);
        list.add(INSTANCE[1]);
        list.add(INSTANCE[2]);
    }

    @Test
    void get() {
        assertThat(list.get(0)).isEqualTo(INSTANCE[0]);
        assertThat(list.get(1)).isEqualTo(INSTANCE[1]);
        assertThat(list.get(2)).isEqualTo(INSTANCE[2]);
    }

    @Test
    void testToString() {
        assertThat(list.toString()).isEqualTo("["+INSTANCE[0]+","+INSTANCE[1]+","+INSTANCE[2]+"]");
    }

    @Test
    void size() {
        assertThat(list.size()).isEqualTo(INSTANCE.length);
    }

    @Test
    void insert() {
        int insertedNum = -1;
        int insertedIdx = 1;
        list.add(insertedNum, insertedIdx);

        for (int i = 0; i < list.size(); i++) {
            if (insertedIdx == i) {
                assertThat(list.get(i)).isEqualTo(insertedNum);
                continue;
            }
            if (insertedIdx < i) {
                assertThat(list.get(i)).isEqualTo(INSTANCE[i - 1]);
                continue;
            }

            assertThat(list.get(i)).isEqualTo(INSTANCE[i]);
        }
    }

    @Test
    void stringList() {
        MyList<String> myStringList = new MyList<>();
        for (int i = 0; i < STRING_INSTANCE.length; i++) {
            myStringList.add(STRING_INSTANCE[i]);
        }

        for (int i = 0; i < myStringList.size(); i++) {
            assertThat(myStringList.get(i)).isEqualTo(STRING_INSTANCE[i]);
        }
    }
}