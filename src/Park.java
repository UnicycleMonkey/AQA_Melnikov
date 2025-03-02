import java.time.LocalTime;
import java.util.ArrayList;

/*Создать класс Park с внутренним классом, с помощью объектов которого
можно хранить информацию об аттракционах, времени их работы и стоимости.*/
public class Park {
    private final ArrayList<Attraction> attractionList;

    public class Attraction {
        private String name;
        private LocalTime openTime;
        private LocalTime closeTime;
        private double cost;

        public void setName(String attractionName) {
            this.name = attractionName;
        }
        public void setOpenTime(LocalTime openTime) {
            this.openTime = openTime;
        }
        public void setCloseTime(LocalTime closeTime) {
            this.closeTime = closeTime;
        }
        public void setCost (double cost) {
            this.cost = cost;
        }

        public void printAttractionInfo(){
            System.out.println("Сведения об аттракционе \""+name+"\":");
            System.out.printf("Открыт с %tT по %tT\n", openTime, closeTime);
            System.out.println("Стоимость билета: "+cost);
        }

    }

    public Park(){
        attractionList = new ArrayList<Attraction>();
    }

    public void addAttraction (String name,LocalTime openTime, LocalTime closeTime, double cost){
        Attraction newAttraction = new Attraction();
        newAttraction.setName(name);
        newAttraction.setOpenTime(openTime);
        newAttraction.setCloseTime(closeTime);
        newAttraction.setCost(cost);
        attractionList.add(newAttraction);
    }

    public void printParkInfo(){
        System.out.println("Информация об аттракционах парка:");
        for (Attraction a: attractionList) {
            a.printAttractionInfo();
        }
    }
}
