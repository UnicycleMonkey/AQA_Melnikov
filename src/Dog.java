public class Dog extends Animal {
    private final static double MAX_RUN_DISTANCE = 500;
    private final static double MAX_SWIM_DISTANCE = 10;
    private static int counter = 0;

    public Dog(String name){
        super(name);
        super.setMaxRunDistance(MAX_RUN_DISTANCE);
        super.setMaxSwimDistance(MAX_SWIM_DISTANCE);
        counter++;
    }

    public static int getCounter(){
        return counter;
    }
}
