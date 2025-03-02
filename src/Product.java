import java.time.LocalDate;

/* 1.Создать класс "Товар" с полями: название, дата производства,
производитель, страна происхождения, цена, состояние бронирования
покупателем. Конструктор класса должен заполнять эти поля при создании
объекта. Внутри класса "Товар" написать метод, который выводит
информацию о6 объекте в консоль.
*/
public class Product {
    private final int id;
    private String name;
    private LocalDate manufacturingDate;
    private String manufacturer;
    private String country;
    private double cost;
    private BookingStatuses currentBookingStatus;

    private static Integer currentId = null;
    public enum BookingStatuses{
        FREE,
        BOOKED
    }

    private Product() {
    //Генерация уникального id
        if(currentId == null) {
            currentId = 0;
        }
        id = ++currentId;
    }

    public Product(String name,
                   LocalDate date,
                   String manufacturer,
                   String country,
                   double cost){
        this();
        this.name=name;
        this.manufacturingDate=date;
        this.manufacturer=manufacturer;
        this.country=country;
        this.cost=cost;
        this.currentBookingStatus = BookingStatuses.FREE;
    }

    public Product(String name,
                   LocalDate date,
                   String manufacturer,
                   String country,
                   double cost,
                   BookingStatuses status){
        this(name,date,manufacturer,country,cost);
        switch (status) {
            case BOOKED:
                this.book();
                break;
            case FREE:
                this.cancelBooking();
                break;
            default:
                this.cancelBooking();
        }
    }

    public boolean book(){
        if (currentBookingStatus==BookingStatuses.BOOKED){
            return false;
        }
        currentBookingStatus=BookingStatuses.BOOKED;
        return true;
    }

    public boolean cancelBooking(){
        if (currentBookingStatus==BookingStatuses.FREE){
            return false;
        }
        currentBookingStatus=BookingStatuses.FREE;
        return true;
    }

    public void printProductInfo(){
        System.out.println("Информация о продукте id"+id+":");
        System.out.println("Наименование: "+name);
        System.out.printf("Дата производства: %td.%tm.%tY\n",
                manufacturingDate,manufacturingDate,manufacturingDate);
        System.out.println("Компания производитель: \""+manufacturer+"\"");
        System.out.println("Страна производства: "+country);
        System.out.println("Стоимость: "+cost);
        System.out.print("Статус бронирования: ");
        switch (currentBookingStatus) {
            case BOOKED:
                System.out.println("Заказано");
                break;
            case FREE:
                System.out.println("Свободно");
                break;
            default:
                System.out.println("Не определен");
        }
    }
}
