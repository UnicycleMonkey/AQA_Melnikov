public class Cat extends Animal {
    private final static double MAX_RUN_DISTANCE = 200;
    private final static double MAX_SWIM_DISTANCE = 0;
    private static int counter = 0;

    public Cat(String name){
        super(name);
        super.setMaxRunDistance(MAX_RUN_DISTANCE);
        super.setMaxSwimDistance(MAX_SWIM_DISTANCE);
        counter++;
    }

    public static int getCounter(){
        return counter;
    }
}
