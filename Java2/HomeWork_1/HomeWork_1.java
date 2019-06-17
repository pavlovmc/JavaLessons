package Lesson_1;

public class HomeWork_1 {

    public static void main(String[] args) {
        Member [] members = {new Member("Tirion", 1800, 2, 25),
                new Member("Bart", 2300, 3, 15),
                new Member("Jon", 1150, 2, 50),
                new Member("Ramcy", 5000, 4, 1000)};
        Team newTeam = new Team("Bastards", members);
        Course course = new Course(3000,3,500);

        System.out.println(newTeam.toString());

        course.showCourse();
        course.doIt(newTeam);
    }
}
