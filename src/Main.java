import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
 //Создать массив из 5 товаров.
        Product[] productsArray = {   //02
            new Product(
                "Мыло",
                LocalDate.of(2025, Month.JANUARY,1),
                "Рога&Копыта",
                "Беларусь",
                100500),
            new Product(
                "Веревка",
                LocalDate.of(1889, Month.MARCH,31),
                "РотФронт",
                "Кирибати",
                123456.78,
                Product.BookingStatuses.FREE),
            new Product(
                "Вжух",
                LocalDate.of(2001, Month.SEPTEMBER,11),
                "Трактористы Inc",
                "Афганистан",
                300,
                Product.BookingStatuses.BOOKED),
            new Product(
                "End of Days",
                LocalDate.of(2012, Month.DECEMBER,31),
                "Майя",
                "Мексика",
                9999),
            new Product(
                "Знания",
                LocalDate.of(1990, Month.FEBRUARY,3),
                "ООО \"Опыт\"",
                "Монако",
                9876543.21,
                Product.BookingStatuses.BOOKED)
        };
        for (Product p:productsArray){
            p.printProductInfo();
        }
        
        Park parkInstance = new Park(); //03
        initializePark (parkInstance);
        System.out.println();
        parkInstance.printParkInfo();
    }

    private static void initializePark(Park park) {
        park.addAttraction(
                "aaaa",
                LocalTime.of(10,23),
                LocalTime.of(12,0),
                100);
        park.addAttraction(
                "бббб",
                LocalTime.of(7,11),
                LocalTime.of(23,23),
                200);
    }
}
