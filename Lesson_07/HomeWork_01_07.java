package Lesson_07;

public class HomeWork_01_07 {

    static public void main(String[] args) {
        Cat[] cats = {new Cat("Барсик", 20),
                new Cat("Васька", 25),
                new Cat("Мурка", 30),
                new Cat("Нарик", 20),
                new Cat("КотеГ", 15)
        };
        Plate plate = new Plate(75);

        feedCats(cats, plate);
        getCatsInfo(cats);
        plate.info();
        plate.addFood(50);
        feedCats(cats, plate);
        getCatsInfo(cats);
        plate.info();
        plate.addFood(10);
        plate.info();
    }

    static private void feedCats(Cat[] cats, Plate plate){
        for (Cat cat : cats) {
            if(!cat.isFull()) {
                if(cat.eat(plate)) {
                    System.out.println(cat.getName() + " поел из тарелки.");
                }else {
                    System.out.println("Коту " + cat.getName() + " не хватило еды в тарелке.");
                }
            } else {
                System.out.println(cat.getName() + " сыт и не хочет кушать.");
            }
        }
    }

    static private void getCatsInfo(Cat[] cats){
        for (Cat cat: cats) {
            System.out.println(cat.getName() + (cat.isFull() ? " сыт." : " голодный."));
        }
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean full;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.full = false;
    }

    boolean isFull() {
        return full;
    }

    String getName() {
        return name;
    }

    boolean eat(Plate p) {
        if(p.getFood()>appetite){
            p.decreaseFood(appetite);
            full = true;
            return true;
        }
        return false;
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    int getFood() {
        return food;
    }

    void decreaseFood(int food) {
        this.food -= food;
    }

    void addFood(int food) {
        this.food += food;
    }

    void info(){
        System.out.println("В тарелке осталось " + food + " единиц еды.");
    }
}
