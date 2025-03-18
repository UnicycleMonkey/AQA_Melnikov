package AQA07;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static AQA07.Main.calculateTriangleSquare;
import static org.junit.jupiter.api.Assertions.*;

class TriangleSquareTest {

    @ParameterizedTest
    @CsvSource(value = {
            "3, 4, 5, 6",
            "17, 10, 9, 36",
            "13, 13, 10, 60"
    })
    @DisplayName("Корректные треугольники")
    void testCorrectSidesTriangle(double a, double b, double c, double result) {
        assertEquals(result,calculateTriangleSquare(a,b,c));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-1,2, 5",
            "-5.25, 14, -6.777",
            "0, 0.007, -12",
            "5, 7, 0",
            "-0, -1, -0.1",
            "1, -7, 1"
    })
    @DisplayName("Невозможные треугольники")
    void testIllegalSidesTriangle(double a, double b, double c) {
        assertThrows(IllegalArgumentException.class,()-> calculateTriangleSquare(a,b,c));
    }
}