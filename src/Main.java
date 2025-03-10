public class Main {
    private static final double CONTAINER_CAPACITY = 150;
    private static final double INITIAL_FOOD_AMOUNT = 70;

    public static void main(String[] args) {
        //Задание 1 (с животными)
        FoodContainer plate = new FoodContainer(CONTAINER_CAPACITY, INITIAL_FOOD_AMOUNT);
        Dog sharik = new Dog("Шарик");
        forceToEat(sharik, plate);
        forceCardioTraining(sharik, 100,10);
        Cat murzik = new Cat("Мурзик");
        forceCardioTraining(murzik, 100, 10);

        Cat[] cats = createAndInitializeCats();
        for (Cat c: cats){
            forceToEat(c,plate);
            printContainerInfo(plate);
        }
        printAnimalContersInfo();

        //Задание 2 (с фигурами)

    }

    private static void forceCardioTraining(Animal animal, double runDistance, double swimDistance) {
        forceToRun(animal,runDistance);
        forceToSwim(animal, swimDistance);
    }

    private static void printContainerInfo(FoodContainer plate) {
        System.out.printf("В тарелке осталось %.2f еды\n", plate.getCurrentAmount());
    }

    private static void printAnimalContersInfo() {
        System.out.printf("Было создано %d шт. всяческих зверюг (%d шт. собак и %d шт. котов)\n",
                Animal.getCounter(), Dog.getCounter(), Cat.getCounter());
    }

    private static void forceToEat(Animal animal, FoodContainer container) {
        double eatenAmount = animal.eatFromContainer(container);
        if (eatenAmount>0){
            System.out.printf("%s (id%d)  cожрал(а) %.2f единиц пищи\n", animal.getName(), animal.getId(), eatenAmount);
        }
        else{
            System.out.printf("%s (id%d)  побрезговал(а) жрать так мало и голодает\n", animal.getName(), animal.getId());
        }
    }

    private static void forceToRun(Animal animal, double distance){
        if (animal.run(distance)){
            System.out.printf("%s (id%d) успешно пробежал(а) %.2f метров\n",animal.getName(), animal.getId(), distance);
        }
        else {
            System.out.printf("%s (id%d) не смог(ла) пробежать %.2f метров [и сдох(ла)]\n", animal.getName(), animal.getId(), distance);
        }

    }
    private static void forceToSwim(Animal animal, double distance){
        if (animal.swim(distance)){
            System.out.printf("%s (id%d) успешно проплыл(а) %.2f метров\n", animal.getName(), animal.getId(), distance);
        }
        else {
            System.out.printf("%s (id%d) не смог(ла) проплыть %.2f метров [и утонул(а)]\n", animal.getName(), animal.getId(), distance);
        }

    }

    private static Cat[] createAndInitializeCats(){
        Cat[] cats ={
                new Cat("Пушок"),
                new Cat("Беляшик"),
                new Cat("Барсик"),
                new Cat("Мурка"),
                new Cat("Барбариска")
        };
        return  cats;
    }

}
