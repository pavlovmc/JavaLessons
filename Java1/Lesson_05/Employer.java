package Lesson_05;

public class Employer {

    private String name;
    private String role;
    private String email;
    private String mobile;
    private String salary;
    private int age;

    public Employer(String name, String role, String email, String mobile, String salary, int age) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.mobile = mobile;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        int tmp = age;
        return tmp;
    }

    public void printInfo(){
        System.out.println(name + " " + role + " " + email + " " + mobile + " " + salary + " " + age);
    }
}
