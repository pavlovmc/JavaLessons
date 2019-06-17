package Lesson_1;

public class Member implements Actions{
    private String name;
    private long runDistance;
    private double jumpDistance;
    private int swimDistance;

    Member(String name, long run, int jump, int swim) {
        this.name = name;
        this.runDistance = run;
        this.jumpDistance = jump;
        this.swimDistance = swim;
    }

    @Override
    public String toString() {
        return "Member{Имя = " + name  + ", длина бега = "
                + runDistance + ", длина прыжка = " + jumpDistance +
                ", длина заплыва = " + swimDistance + "}";
    }

    public void memberInfo(){
        System.out.println(toString());
    }

    public String getName() {
        return this.name;
    }

    @Override
    public long run() {
        return this.runDistance;
    }

    @Override
    public double jump() {
        return this.jumpDistance;
    }

    @Override
    public int swim() {
        return this.swimDistance;
    }
}
