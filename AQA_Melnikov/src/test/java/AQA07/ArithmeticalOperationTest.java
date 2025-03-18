package AQA07;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static AQA07.Main.provideArithmeticalOperation;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticalOperationTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3",
            "-17.5, 12.4, -5.1",
            "0, 0, 0"
    })
    @DisplayName("Сложение")
    void testAddition(double a, double b, double result) {
        assertEquals(result,provideArithmeticalOperation(a,ArithmeticalOperations.ADDITION,b));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, -1",
            "-17.5, 12.4, -29.9",
            "0, 0, 0"
    })
    @DisplayName("Вычитание")
    void testSubtraction(double a, double b, double result) {
        assertEquals(result,provideArithmeticalOperation(a,ArithmeticalOperations.SUBSTRACTION,b));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 2",
            "-17.5, 12.4, -217",
            "0, 0, 0"
    })
    @DisplayName("Умножение")
    void testMultiplication(double a, double b, double result) {
        assertEquals(result,provideArithmeticalOperation(a,ArithmeticalOperations.MULTIPLICATION,b));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 0.5",
            "-16.5, 4, -4.125",
            "0, 125, 0"
    })
    @DisplayName("Корректное деление")
    void testCorrectDivision(double a, double b, double result) {
        assertEquals(result,provideArithmeticalOperation(a,ArithmeticalOperations.DIVISION,b));
    }

    @Test
    @DisplayName("Деление на 0")
    public void testDivisionByZero() {
        assertThrows(CustomDivisionByZeroException.class,() ->
                provideArithmeticalOperation(0,ArithmeticalOperations.DIVISION,0));
    }
}