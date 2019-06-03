package Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PhoneBook {
    private Map<String, List<String>> phoneList = new HashMap<>();

    void add(String name, String phoneNumber){

        if(phoneList.containsKey(name)) {
            phoneList.get(name).add(phoneNumber);
        }
        else { List<String> tmpList = new ArrayList<>(); tmpList.add(phoneNumber);
            phoneList.put(name,tmpList);}
    }

    void get(String name) {
        System.out.println("Phone number of client " + name + ": " + phoneList.get(name));
    }

}
