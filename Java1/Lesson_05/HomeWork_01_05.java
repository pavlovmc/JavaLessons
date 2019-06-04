package Lesson_05;

public class HomeWork_01_05 {

    static public void main(String[] args){
        Employer[] employers = new Employer[5];

        employers[0] = new Employer("Иванов Иван Иваныч", "дворник",
                "ivanov@ru.ru", "88005551234", "15000 руб", 45);
        employers[1] = new Employer("Dart Vader", "Sith", "vader@imperia.com", "555007",
                "100500$", 39);
        employers[2] = new Employer("Shepard", "Commander", "shepard@earh.com", "5550777",
                "100000$", 30);
        employers[3] = new Employer("Mario Mario", "plumber", "mario@nintendo.com", "1110053",
                "65000$", 27);
        employers[4] = new Employer("Serious Sam","Solder","sam@croteam.com", "555666",
                "500000$", 30);

        for (int i = 0; i < employers.length; i++) {
            if(employers[i].getAge()>40){
                employers[i].printInfo();
            }
        }

    }
}
