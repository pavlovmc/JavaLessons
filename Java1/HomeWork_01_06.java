package Lesson_06;

public class HomeWork_01_06 {

    static public void main(String[] args){

        Animal standardCat = new Cat();
        // В теории можно сделать разброс в ограничениях через конструктор, используя random
        Animal strongCat = new Cat(300, 0, 3f);
        Animal weakCat = new Cat(100, 0, 1f);

        Animal standardDog = new Dog();
        Animal strongDog = new Dog(600, 20, 1f);
        Animal weakDog = new Dog(400, 5, 0.1f);

        Animal[] animals = {standardCat,strongCat,weakCat,standardDog,strongDog,weakDog};
        // Можно добавить поле имя и там прописать имя живтного для более красивого вывода
        int i = 1;
        for (Animal animal: animals) {
            System.out.print("Производится тестрование животного " + i + ": ");
            System.out.print("бег на 150 м "+ animal.run(150));
            System.out.print(", плавание на 15 м "+ animal.swim(15));
            System.out.print(", прыжок на 1 м "+ animal.jump(1f));
            System.out.println();
            i++;
        }
    }
}


abstract class Animal {
    protected int maxDistance;
    protected int maxSwim;
    protected float maxJump;

    public Animal() {
        this.maxDistance = 0;
        this.maxSwim = 0;
        this.maxJump = 0f;
    }

    public Animal(int maxDistance, int maxSwim, float maxJump) {
        this.maxDistance = maxDistance;
        this.maxSwim = maxSwim;
        this.maxJump = maxJump;
    }

    public boolean run(int distance) {
        return distance<=maxDistance;
    }

    public boolean swim(int distance) {
        return distance<=maxSwim;
    }

    public boolean jump(float jump) {
        return jump<=maxJump;
    }
}

class Cat extends Animal {

    public Cat(int maxDistance, int maxSwim, float maxJump) {
        super(maxDistance, maxSwim, maxJump);
    }

    public Cat() {
        super();
        this.maxDistance = 200;
        this.maxSwim = 0;
        this.maxJump = 2f;
    }

    public boolean swim(int distance){
        return false;
    }
}

class Dog extends Animal {

    public Dog(int maxDistance, int maxSwim, float maxJump) {
        super(maxDistance, maxSwim, maxJump);
    }

    public Dog() {
        super();
        this.maxDistance = 500;
        this.maxSwim = 10;
        this.maxJump = 0.5f;
    }
}
