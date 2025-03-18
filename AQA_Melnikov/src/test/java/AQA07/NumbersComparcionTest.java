package AQA07;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static AQA07.Main.compareNumbers;
import static org.junit.jupiter.api.Assertions.*;

public class NumbersComparcionTest {
    @ParameterizedTest
    @CsvSource(value = {
            "54, -13",
            "17, 10",
            "0, -3.14"
    })
    @DisplayName("a > b")
    void testGreaterThan(double a, double b) {
        assertEquals(NumbersComparcion.GREATER_THAN,compareNumbers(a,b));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-3.11, 4.18",
            "9.19, 36",
            "10.1, 60.666"
    })
    @DisplayName("a < b")
    void testLesserThan(double a, double b) {
        assertEquals(NumbersComparcion.LESSER_THAN,compareNumbers(a,b));
    }

    @Test
    @DisplayName("a = b")
    public void testEquals(){
        assertEquals(NumbersComparcion.EQUAL, compareNumbers(2,2));
    }
}