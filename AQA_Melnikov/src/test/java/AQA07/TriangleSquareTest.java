package AQA07;

import jdk.jfr.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static AQA07.Main.calculateTriangleSquare;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class TriangleSquareTest {
    @DataProvider
    public  Object[][] getTrueTriangles() {
        return  new Object[][]{
                new Object[]  {3, 4, 5, 6},
                new Object[]   {17, 10, 9, 36},
                new Object[]   {13, 13, 10, 60}
        };
    }

    @Test (dataProvider = "getTrueTriangles")
    @Description("Корректные треугольники")
    void testCorrectSidesTriangle(double a, double b, double c, double result) {
        assertEquals(result,calculateTriangleSquare(a,b,c));
    }


//    @CsvSource(value = {
//            "-1,2, 5",
//            "-5.25, 14, -6.777",
//            "0, 0.007, -12",
//            "5, 7, 0",
//            "-0, -1, -0.1",
//            "1, -7, 1"
//    })
    @DataProvider
    public  Object[][] getFalseTriangles() {
    return  new Object[][]{
            new Object[]    {-1,2, 5},
            new Object[]    {-5.25, 14, -6.777},
            new Object[]    {0, 0.007, -12},
            new Object[]    {5, 7, 0},
            new Object[]    {-0, -1, -0.1},
            new Object[]    {1, -7, 1}
    };
}

    @Test (dataProvider = "getFalseTriangles")
    @Description("Невозможные треугольники")
    void testIllegalSidesTriangle(double a, double b, double c) {
        assertThrows(IllegalArgumentException.class,()-> calculateTriangleSquare(a,b,c));
    }
}
