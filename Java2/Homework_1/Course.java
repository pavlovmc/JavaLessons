package Lesson_1;

class Course {
    private long runDistance;
    private double jumpDistance;
    private int swimDistance;

    Course(long run, double jump, int swim) {
        this.runDistance = run;
        this.jumpDistance = jump;
        this.swimDistance = swim;
    }

    void doIt(Team team) {
        int j = 0;
        Member [] memberList =  team.getMembers();

        for (Member member : memberList) {
            if (member.run() >= runDistance) {
                j++;
            }
        }
        int flag = 0;
        if (j == memberList.length-1) {
            System.out.println("Все игроки пробежали дистанцию " + runDistance + " метров");
            flag++;
        }

        j = 0;

        for (Member member : memberList) {
            if (member.jump() >= jumpDistance) {
                j++;
            }
        }

        if (j == memberList.length-1) {
            System.out.println("Все игроки перепрыгнули ров шириной " + jumpDistance + " метра(ов)");
            flag++;
        }

        j = 0;

        for (Member member : memberList) {
            if (member.swim() >= swimDistance) {
                j++;
            }
        }

        if (j == memberList.length-1) {
            System.out.println("Все игроки проплыли дистанцию " + swimDistance + " метров");
            flag++;
        }

        if (flag == 3) {
            System.out.println("Команда прошла полосу препятствий УСПЕШНО !!!");
        } else {
            System.out.println("Команда не прошла полосу препятствий");
        }
    }

    void showCourse(){
        System.out.println("Дистанция забега - " + runDistance
                + " м.; Ширина рва " + jumpDistance +
                " м.;  Дистанция заплыва " + swimDistance + " м.;");
    }

}
