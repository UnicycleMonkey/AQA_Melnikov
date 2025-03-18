package AQA07;

import jdk.jfr.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static AQA07.Main.compareNumbers;
import static org.testng.Assert.assertEquals;

public class NumbersComparcionTest {
    @DataProvider
    public  Object[][] getGreaterThanData() {
        return  new Object[][]{
                new Object[]  {54, -13},
                new Object[]  {17, 10},
                new Object[]  {0, -3.14},
        };
    }

    @Test (dataProvider = "getGreaterThanData")
    @Description("a > b")
    void testGreaterThan(double a, double b) {
        assertEquals(NumbersComparcion.GREATER_THAN,compareNumbers(a,b));
    }

    @DataProvider
    public  Object[][] getLesserThanData() {
        return  new Object[][]{
                new Object[]  {-3.11, 4.18},
                new Object[]  {9.19, 36},
                new Object[]  {10.1, 60.666},
        };
    }

    @Test (dataProvider = "getLesserThanData")
    @Description("a < b")
    void testLesserThan(double a, double b) {
        assertEquals(NumbersComparcion.LESSER_THAN,compareNumbers(a,b));
    }

    @Test
    @Description("a = b")
    public void testEquals(){
        assertEquals(NumbersComparcion.EQUAL, compareNumbers(2,2));
    }
}
