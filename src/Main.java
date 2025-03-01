import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printThreeWords(); //01
        checkSumSign();   //02
        printColor();   //03
        compareNumbers();   //04

        int a05=2, b05=10;  //05
        String possibleNot05=sumLaysBetween10And20(a05,b05)?"":" не";
        System.out.println("Сумма "+a05+" и "+b05+possibleNot05+" лежит в полуинтервале (10;20]");

        printIsNumberPositive(generateRandomInt(-3,3)); //06

        int num07=generateRandomInt(-3,3);  //07
        String possibleNot07=isNumberNegative(num07)?"":" не";
        System.out.println("Число "+num07+possibleNot07+" является отрицательным");

        printStringNTimes("Cookies!",3); //08

        int year09 = 2100;  //09
        String possibleNot09=(isYearLeap(year09))?"":" не";
        System.out.println("Год "+year09+possibleNot09+" является високосным");

        reverse1and0InArray(); //10
        fillArray1to100();    //11
        doubleNumbersLess6InArray();    //12
        fillDiagonalsWith1(); //13

        int[] array14 = createAndInitializeArray(8, 69);    //14
        System.out.println("Массив:\n"+ Arrays.toString(array14));


    }

/* 1.Создайте метод printThreeWords(), который при вызове должен отпечатать
     в столбец три слова: Orange, Banana, Apple.
*/
    private static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

/* 2.Создайте метод checkSumSign(), в теле которого объявите две int переменные
    а и b, и инициализируйте их любыми значениями, которыми захотите. Далее метод должен
    просуммировать эти переменные, и если их сумма больше или равна 0, то вывести в консоль
    сообщение "Сумма положительная", в противном случае - "Сумма отрицательная";
 */
    private static void  checkSumSign(){
        int a = generateRandomInt(-10,10);
        int b = generateRandomInt(-6,2);
        System.out.println("Values are: "+a+", "+b);
        if (isNumberPositive(a+b)) {
            System.out.println("Сумма положительная");
        }
        else{
            System.out.println("Сумма отрицательная");
        }
    }

/* 3.Создайте метод printColor() в теле которого задайте int переменную value
    и инициализируйте ее любым значением. Если value меньше 0 (0 включительно), то в консоль
    метод должен вывести сообщение "Красный", если лежит в пределах от 0 (0 исключительно)
    до 100 (100 включительно), то "Желтый", если больше 100 (100 исключительно) - "Зеленый";
 */
    private static void printColor(){
        String resultColor;
        int randomValue = generateRandomInt(-100,200);
        System.out.println("Value: "+randomValue);
        if (randomValue<=0){
            resultColor="Красный";
        }
        else if (randomValue<=100) {
            resultColor="Желтый";
        }
        else{
            resultColor="Зеленый";
        }
        System.out.println(resultColor);
    }

/* 4.Создайте метод compareNumbers(), в теле которого объявите две int переменные
    а и b, и инициализируйте их любыми значениями, которыми захотите. Если а больше или равно b,
    то необходимо вывести в консоль сообщение "а >= b", в противном случае "а < b";
*/
    private static void compareNumbers(){
        int a = generateRandomInt(0,10);
        int b = generateRandomInt(0,10);
        System.out.println("Values are: "+a+", "+b);
        String result= ((a >= b)? "а >= b": "а < b");
        System.out.println(result);
    }

/* 5.Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма
    лежит в пределах от 10 до 20 (включительно), если да — вернуть true, в противном случае —false.
 */
    private static boolean sumLaysBetween10And20(int num1, int num2){
        int sum=num1+num2;
        return (sum>10)&&(sum<=20);
    }

/* 6.Напишите метод, которому в качестве параметра передается целое число, метод
    должен напечатать в консоль, положительное ли число передали или отрицательное.
    Замечание: ноль считаем положительным числом.
 */
    private static void printIsNumberPositive(int num){
        String result = isNumberPositive(num)? " положительное": " отрицательное";
        System.out.println("Число "+num+result);
    }

/* 7.Напишите метод, которому в качестве параметра передается целое число. Метод
    должен вернуть true, если число отрицательное, и вернуть false если положительное.
    Замечание: ноль считаем положительным числом.
*/
    private static boolean isNumberNegative(int num){
        return !isNumberPositive(num);
    }

/* 8.Напишите метод, которому в качестве аргументов передается строка и число,
    метод должен отпечатать в консоль указанную строку, указанное количество раз;*/
    private static void printStringNTimes(String str, int n){
        if(n>0) {
            for (int i = 0; i<n; i++) {
                System.out.println(str);
            }
        }
    }

/* 9.Напишите метод, который определяет, является ли год високосным, и возвращает
    boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным,
    кроме каждого 100-го, при этом каждый 400-й — високосный.*/
    private static boolean isYearLeap(int year){
        //хоть первым високосным годом был 45 до н.э., до 8 года н.э. алгоритм не работал (согласно Вики)
        if (year < 8){
            return false;
        }

        boolean result;
        if (year%400 == 0) {
            result=true;
        } else if(year%100 == 0){
            result = false;
        } else result= (year%4==0);
        return result;
    }

/* 10.Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
     [ [1, 1, 0, 0,1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1,1 на 0;*/
    private static void reverse1and0InArray(){
        final int SIZE = 8;
        int[] array = new int[SIZE];
        for (int i=0;i<array.length;i++){
            array[i]=generateRandomInt(0,1);
        }
        System.out.println("Исходный массив:\n"+ Arrays.toString(array));
        for (int i=0;i<array.length;i++){
            array[i]=(array[i]==0)? 1 :0;
        }
        System.out.println("Преобразованный массив:\n"+ Arrays.toString(array));
    }

/* 11.Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;*/
    private static void fillArray1to100(){
        final int SIZE = 100;
        int[] array = new int[SIZE];
        for (int i=0;i<array.length;i++){
            array[i]=i+1;
        }
        System.out.println("Массив:\n"+ Arrays.toString(array));
    }

/* 12.Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1] пройти по нему циклом, и числа меньшие 6 умножить на 2;*/
    private static void doubleNumbersLess6InArray(){
        int[] array = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив:\n"+ Arrays.toString(array));
        for (int i=0;i<array.length;i++){
            if(array[i]<6){
                array[i]*=2;
            }
        }
        System.out.println("Массив:\n"+ Arrays.toString(array));
    }

/* 13.Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
    если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких
    элементов равны, то есть [0][0], [1][1], [2][2], ..., [п][п];*/
    private static void fillDiagonalsWith1(){
        final int SIZE = 6;
        int[][] square = new int[SIZE][SIZE];
        for (int i=0; i<SIZE;i++){
            for (int j=0; j<SIZE; j++){
                if((i==j) || (i+j==SIZE-1)){
                    square[i][j]=1;
                } else {
                    square[i][j]=0;
                }
            }
        }
        for(int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                System.out.print(square[i][j]+"\t");
            }
            System.out.println();
        }
    }

/* 14.Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный
    массив типа int длиной len, каждая ячейка которого равна initialValue.
*/
    private static int[] createAndInitializeArray(int len, int initialValue){
        if(len<=0){
            return null;
        }
        int[] result = new int[len];
        Arrays.fill(result,initialValue);
        return result;
    }

    private static boolean isNumberPositive(int arg){
        return arg >= 0;
    }

    private static int generateRandomInt(int min, int max) {
        return (int)(Math.random()*(max-min+1)) + min;
    }
}
