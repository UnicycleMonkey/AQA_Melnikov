public  abstract class Animal implements ICanRun, ICanSwim
{
    protected double maxRunDistance;
    protected double maxSwimDistance;

    private String name;
    private static int counter=0;
    private int id;
    private boolean isSate;

    public String getName(){
        return name;
    }

    public Animal(String name){
        this.name=name;
        id=++counter;
    }
     protected void setMaxRunDistance(double distance){
        maxRunDistance = Math.max(distance,0);
     }

    protected void setMaxSwimDistance(double distance){
        maxSwimDistance = Math.max(distance,0);
    }

    public int getId(){
        return id;
    }

    public double eatFromContainer(FoodContainer container){
        final double MAX_AMOUNT = 30;
        double amount = Math.random()*MAX_AMOUNT + 1;
        if (container.tryGetSomeFood(amount)){
            isSate = true;
            return amount;
        }
        else {
            return 0;
        }
    }

    @Override
    public boolean run(double distance) {
        return (distance>=0) && (distance<= maxRunDistance);
    }

    @Override
    public boolean swim(double distance) {
        return  (distance>=0) && (distance<= maxSwimDistance);
    }

    public static int getCounter(){
        return counter;
    }
}
