package ru.netology.module6.junttesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.module6.junittesting.Calculator;

import static org.assertj.core.api.AssertionsForClassTypes.*;


public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {

        calculator = new Calculator();
    }

    @Test
    void givenPositiveNumbers_whenAdd_thenReturnCorrectSum() {

        int a = 5;
        int b = 3;

        int result = calculator.add(a, b);


        assertThat(result).isEqualTo(8);


    }

    @Test
    @DisplayName("Деление на ноль выбрасывает исключение")
    void givenZeroDivisor_whenDivide_thenTrowArithmeticException() {

        int a = 10;
        int b = 0;

        assertThatThrownBy(() -> calculator.divide(a,b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Division by zero is impossible!");

    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "1,1,2",
            "5,3,8",
            "10,-4,6",
            "0,0,0",
            "-5,-3,-8"
    })
    void add_VariousNumbers_ReturnsCorrectSum(int a, int b, int expectedResult){

        int result = calculator.add(a,b);

        assertThat(result).isEqualTo(expectedResult);


    }


}
