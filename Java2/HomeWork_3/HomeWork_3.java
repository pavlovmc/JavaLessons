package Lesson_3;

import java.util.*;

public class HomeWork_3 {

    public static void main(String[] args) {
        ArrayList<String> listStr = new ArrayList();
        Random random = new Random();
        String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        for (int i=0; i<20; i++) {
            listStr.add(words[random.nextInt(10)]);
        }
        System.out.println(listStr);

        Set uniStr = new HashSet(listStr);
        System.out.println(uniStr);

        int counter;
        String str;
        for (int j=0; j < uniStr.size(); j++) {
            str = (String)uniStr.toArray()[j];
            counter = 0;
            for (int i=0; i<20; i++) {
                if(listStr.get(i).equals(str)) {
                    counter++;
                }
            }
            System.out.println("Element " + str + " meet " + counter + " times");
        }

        PhoneBook phones = new PhoneBook();
        phones.add("Alien", "+05551099");
        phones.add("Predator", "+05551001");
        phones.add("Reply", "+05551007");
        phones.add("Alien", "+05551100");
        phones.get("Alien");

    }
}
