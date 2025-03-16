package AQA.melnikov.t2;

import java.util.HashMap;
import java.util.Objects;

public class PhoneDirectory {
    private HashMap <Long, String> directory;

    public boolean add(long phoneNumber, String name){
        return (directory.put(phoneNumber, name)==null);
    }

    public HashMap<Long, String> findByName(String searchName) {
        HashMap<Long, String> result = new HashMap<>();
        directory.forEach( (num, name) ->{
            if (Objects.equals(name, searchName)){
                result.put(num, name);
            }
        });
        return result;
    }

    public PhoneDirectory(HashMap<Long, String> collection){
        directory = collection;
    }

    public HashMap<Long, String> getPhoneDirectory() {
        return directory;
    }
}
