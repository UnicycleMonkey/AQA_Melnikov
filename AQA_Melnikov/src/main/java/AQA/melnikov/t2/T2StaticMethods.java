package AQA.melnikov.t2;

import java.util.HashMap;

public class T2StaticMethods {
    public static void findAndPrintPhones(PhoneDirectory phoneDirectory, String name) {
        System.out.println(" >>> Ищем \""+name+"\":" );
        printPhonesCollection(phoneDirectory.findByName(name));
    }

    public static void printPhonesCollection(HashMap<Long, String> map) {
        map.forEach( (num, name) -> System.out.printf("+%d\t%s\n",num, name));
        System.out.println();
    }

    public static HashMap<Long, String> initializePhoneDirectory() {
        HashMap <Long, String> result = new HashMap<>();
        result.put(12485645L,"Юра");
        result.put(56645645L,"Юра");
        result.put(78985222L,"Саня");
        result.put(54521231L,"Инокентий");
        result.put(45344344L,"Саня");
        result.put(323323223L,"Люба");
        result.put(343478890L,"Юра");
        result.put(441563514L,"Мила");
        return result;
    }
}
