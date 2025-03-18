package AQA07;

import jdk.jfr.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static AQA07.Main.provideArithmeticalOperation;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class ArithmeticalOperationTest {
    @DataProvider
    public  Object[][] getAdditionData() {
        return  new Object[][]{
                new Object[]  {1, 2, 3},
                new Object[]   {-17.5, 12.4, -5.1},
                new Object[]   {0, 0, 0}
        };
    }

    @Test (dataProvider = "getAdditionData" )
    @Description("Сложение")
    void testAddition(double a, double b, double result) {
        assertEquals(result, provideArithmeticalOperation (a, ArithmeticalOperations.ADDITION, b));
    }

    @DataProvider
    public  Object[][] getSubtractionData() {
        return  new Object[][]{
                new Object[]  {1, 2, -1},
                new Object[]   {-17.5, 12.4, -29.9},
                new Object[]   {0, 0, 0}
        };
    }

    @Test (dataProvider = "getSubtractionData")
    @Description("Вычитание")
    void testSubtraction(double a, double b, double result) {
        assertEquals(result,provideArithmeticalOperation(a,ArithmeticalOperations.SUBSTRACTION,b));
    }

    @DataProvider
    public  Object[][] getMultiplicationData() {
        return  new Object[][]{
                new Object[]  {1, 2, 2},
                new Object[]   {-17.5, 12.4, -217},
                new Object[]   {0, 0, 0}
        };
    }

    @Test (dataProvider = "getMultiplicationData" )
    @Description("Умножение")
    void testMultiplication(double a, double b, double result) {
        assertEquals(result,provideArithmeticalOperation(a,ArithmeticalOperations.MULTIPLICATION,b));
    }

    @DataProvider
    public  Object[][] getCorrectDivisionData() {
        return  new Object[][]{
                new Object[]  {1, 2, 0.5},
                new Object[]   {-16.5, 4, -4.125},
                new Object[]   {0, 125, 0}
        };
    }

    @Test   (dataProvider = "getCorrectDivisionData" )
    @Description("Корректное деление")
    void testCorrectDivision(double a, double b, double result) {
        assertEquals(result,provideArithmeticalOperation(a,ArithmeticalOperations.DIVISION,b));
    }

    @Test
    @Description("Деление на 0")
    public void testDivisionByZero() {
        assertThrows(CustomDivisionByZeroException.class,() ->
                provideArithmeticalOperation(0,ArithmeticalOperations.DIVISION,0));
    }
}
