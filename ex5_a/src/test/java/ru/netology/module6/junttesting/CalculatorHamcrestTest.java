package ru.netology.module6.junttesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.module6.junittesting.Calculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;

public class CalculatorHamcrestTest {

    private Calculator calculator;

    @BeforeEach
    void setUp(){

        calculator = new Calculator();

    }

    @Test
    void testAddPositiveNumbers() {

        int a = 5;
        int b = 3;

        int result = calculator.add(a,b);

        assertThat(result, is(equalTo(8)));
        assertThat(result, is(greaterThan(0)));

    }




}
