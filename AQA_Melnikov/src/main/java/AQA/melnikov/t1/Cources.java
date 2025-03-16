package AQA.melnikov.t1;

public enum Cources {
    FIRST (1),
    SECOND (2),
    THIRD (3),
    FOURTH (4),
    FIFTH (5),
    GRADUATE (100500);

    public final static int GRADUATION_YEAR = 5;
    private final int number;

    Cources (int num){
        number = num;
    }

    public int getNumber() {
        return number;
    }

    public static Cources advance(Cources basic){
        Cources result;
        switch (basic){
            case FIRST:
                result = SECOND;
                break;
            case SECOND:
                result = THIRD;
                break;
            case THIRD:
                result = FOURTH;
                break;
            case FOURTH:
                result = FIFTH;
                break;
            default:
                result = GRADUATE;
        }
        return result;
    }
}
