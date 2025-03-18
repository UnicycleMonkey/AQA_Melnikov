package AQA07;

//Напишите 4 программы:
//- позволяющую вычислить факториал числа;
//- позволяющую найти площадь треугольника;
//- совершающую арифметические действия с двумя целыми числами (сложение, вычитание, деление и умножение);
//- сравнивающую два целых числа.
//Эти программы должны быть в каждой ветке.
//
//В ветке Lesson_14_junit_5 напишите юнит-тесты для этих программ, используя Junit 5.
//В ветке Lesson_14_testng напишите юнит-тесты для этих программ, используя TestNG.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    static long factorial(int n){
        if(n<0){
            throw new IllegalArgumentException();
        }
        long result = 1L;
        for (int i = 0; i < n; i++) {
            result*=(i+1);
        }
        return result;
    }

    static double calculateTriangleSquare(double sideA, double sideB, double sideC){
        double p = (sideA + sideB+ sideC)/2;
        double result = p * (p-sideA) * (p-sideB) * (p-sideC);
        if (result<=0) {
           throw new NotTriangleException(String.format("%f, %f, %f - не треугольник", sideA, sideB, sideC));
        }
        return Math.sqrt(result); //Формула Герона
    }

    static double provideArithmeticalOperation (double arg1, ArithmeticalOperations operation, double arg2) {
        double result;
        switch (operation){
            case ADDITION: result = arg1 + arg2;
                break;
            case DIVISION:
                if (arg2==0){
                    throw new CustomDivisionByZeroException("Деление на ноль! ["+arg1+"/0]");
                }
                result = arg1/arg2;
                break;
            case SUBSTRACTION:
                result = arg1 - arg2;
                break;
            default:
                result = arg1 * arg2;
        }
        return result;
    }

    static NumbersComparcion compareNumbers(double number1,double number2){
        if (number1 == number2){
            return NumbersComparcion.EQUAL;
        }
        return (number1>number2)? NumbersComparcion.GREATER_THAN: NumbersComparcion.LESSER_THAN;
    }
}