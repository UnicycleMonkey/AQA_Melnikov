public class Main {
    public static void main(String[] args) {
        String [][] array4x4 = createBroken4x4();
        printSquareStringArray(array4x4);
        printSumArray4x4(array4x4);
        String [][] array5x5 = createAndInitializeSquareArray(5);
        printSquareStringArray(array5x5);
        printSumArray4x4(array5x5);
        generateAndHandleExceptionT4();
    }

    private static void printSumArray4x4(String[][] array) {
        boolean wasExceptionThrown = false;
//        do{
            try{
                System.out.println(calculateSumArray4x4(array));
            }catch (MyArrayDataException e){
                System.out.println(e.getMessage());
            }catch (MyArraySizeException e) {
                System.out.println(e.getMessage());
            }
//        }while(wasExceptionThrown);
    }

    private static void generateAndHandleExceptionT4(){
        final int DEFAULT_SIZE = 4;
        int [] array = new int[DEFAULT_SIZE];
        try{
            int a = array[DEFAULT_SIZE];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("С каждым днем мы все дальше от Бога! А между тем исключение IndexOutOfBoundsException:\n"+e.getMessage());
        }
    }

    private static String[][] createBroken4x4(){
        final int SIZE = 4;
        final int BROKE_TRIES_QUANTITY = 3;
        final String BROKEN_VALUE = "ㆆ_ㆆ";

        String[][] result = createAndInitializeSquareArray(SIZE);
        for (int i = 0; i < BROKE_TRIES_QUANTITY; i++) {
            int randomI = (int)(Math.random()*SIZE);
            int randomJ = (int)(Math.random()*SIZE);
            result[randomI][randomJ] = BROKEN_VALUE; 
        }
        return  result;
    }

    private static String[][] createAndInitializeSquareArray(int size) {
        String[][] result = new String[size][size];
        for (int i = 0; i<size; i++){
            for (int j = 0; j<size; j++){
                result[i][j] = Integer.toString((int)(Math.random()*2*size -size +1));
            }
        }
        return result;
    }

    private static void printSquareStringArray( String[][] array){
        for(int i=0; i<array.length; i++) {
            for (int j=0; j<array[0].length; j++) {
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
    }

    private static int calculateSumArray4x4(String[][] array){
        final int RIGHT_SIZE = 4;
        if(array.length!=RIGHT_SIZE){
            throw  new MyArraySizeException("Массив содержит неверное число строк ("+array.length+")",array.length);
        }
        for (String[] sa: array){
            if (sa.length!=RIGHT_SIZE){
                throw  new MyArraySizeException("Массив содержит неверное число столбцов ("+sa.length+")",sa.length);
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum+=Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException( e.getMessage()
                            +String.format("\nНеверное значение элемента [%d][%d]",i,j), new int[] {i,j});
                }
            }
        }

        return sum;
    }
}
