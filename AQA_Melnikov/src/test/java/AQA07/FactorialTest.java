package AQA07;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static AQA07.Main.factorial;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {
    @Test
    @DisplayName("0!=1")
    public void testFactorial0(){
        assertEquals(1,factorial(0));
    }

    @Test
    @DisplayName("1!=1")
    public void testFactorial1(){
        assertEquals(1,factorial(1));
    }

    @ParameterizedTest
    @CsvSource (value = {
            "2,2",
            "3,6",
            "4,24",
            "5,120",
            "6,720",
            "9,362880"
    })
    @DisplayName("n!")
    public void testFactorialN(int argument, long result){
        assertEquals(result,factorial(argument));
    }

    @Test
    @DisplayName("(-1)!= IllegalArgumentException")
    public void testFactorialNegative(){
        assertThrows(IllegalArgumentException.class,()-> factorial(-1));
    }


}