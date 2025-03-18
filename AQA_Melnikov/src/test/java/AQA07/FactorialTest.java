package AQA07;

import jdk.jfr.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static AQA07.Main.factorial;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialTest {
    @Test
    @Description("0!=1")
    public void testFactorial0(){
        assertEquals(1,factorial(0));
    }

    @Test
    @Description("1!=1")
    public void testFactorial1(){
        assertEquals(1,factorial(1));
    }

    @DataProvider
    public  Object[][] getFactorialData() {
        return  new Object[][]{
                new Object[]  {2,2},
                new Object[]  {3,6},
                new Object[]  {4,24},
                new Object[]  {5,120},
                new Object[]  {6,720},
                new Object[]  {9,362880}
        };
    }

    @Test (dataProvider = "getFactorialData")
    @Description("n!")
    public void testFactorialN(int argument, long result){
        assertEquals(result,factorial(argument));
    }

    @Test
    @Description("(-1)!= IllegalArgumentException")
    public void testFactorialNegative(){
        assertThrows(IllegalArgumentException.class,()-> factorial(-1));
    }

}
