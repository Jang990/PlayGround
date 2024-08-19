package com.tutorial.java.refactoring.ch1;

import com.tutorial.java.refactoring.ch1.data.Invoice;
import com.tutorial.java.refactoring.ch1.data.Performance;
import com.tutorial.java.refactoring.ch1.data.Play;
import com.tutorial.java.refactoring.ch1.data.Type;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class Statement_1Test {
    private Statement_1 statement1 = new Statement_1();

    @Test
    void test() {
        String result = statement1.statement(TestConst.INVOICES, TestConst.PLAYS);
        assertThat(result).isEqualTo(TestConst.RESULT);
    }

}