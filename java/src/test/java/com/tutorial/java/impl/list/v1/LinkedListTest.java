package com.tutorial.java.impl.list.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest {
    private List<Integer> list;
    private final int[] INSTANCE = {236, 10012, 5465};
    final String[] STRING_INSTANCE = {"A", "B", "C"};

    @BeforeEach
    void beforeEach() {
        list = new LinkedList<>();
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
        System.out.println(list);
        assertThat(list.toString()).isEqualTo("["+INSTANCE[0]+", "+INSTANCE[1]+", "+INSTANCE[2]+"]");
    }

    @Test
    void size() {
        assertThat(list.size()).isEqualTo(INSTANCE.length);
    }

    @Test
    void insert() {
        int insertedNum = -1;
        int insertedIdx = 1;
        list.add(insertedIdx, insertedNum);

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
    void containsTrue() {
        boolean result = list.contains(INSTANCE[0]);
        assertThat(result).isTrue();
    }

    @Test
    void containsFalse() {
        Integer excludesNum = Integer.MIN_VALUE;
        boolean result = list.contains(excludesNum);
        assertThat(result).isFalse();
    }

    @Test
    void removeIncludedNum() {
        Integer includedNum = INSTANCE[0];
        boolean result = list.remove(includedNum);

        assertThat(list.size()).isEqualTo(INSTANCE.length - 1);
        assertThat(list.contains(includedNum)).isFalse();
        assertThat(result).isTrue();
    }

    @Test
    void removeExcludedNum() {
        Integer excludedNum = Integer.MIN_VALUE;
        boolean result = list.remove(excludedNum);

        assertThat(list.size()).isEqualTo(INSTANCE.length);
        assertThat(result).isFalse();
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
