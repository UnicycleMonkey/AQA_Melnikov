public class FoodContainer {
    private final double capacity;
    private double currentAmount;

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void fill(){
        fill(capacity);
    }
    public void fill(double amount){
        currentAmount = Math.min((currentAmount + amount), capacity);
    }

    public boolean tryGetSomeFood(double amount){
        boolean wasSuccessful = (amount<=currentAmount);
        if (wasSuccessful){
            currentAmount-=amount;
        }
        return wasSuccessful;
    }

    public FoodContainer(double capacity, double amount){
        if (capacity<=0){
            this.capacity=0;
        } else {
            this.capacity = capacity;
        }
        if(amount<0) {
            this.currentAmount = 0;
        }else if (amount>this.capacity){
            this.currentAmount=this.capacity;
        }else{
            this.currentAmount=amount;
        }
    }
}
