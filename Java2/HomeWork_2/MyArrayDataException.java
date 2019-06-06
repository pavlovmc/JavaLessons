package Lesson_2;

public class MyArrayDataException extends Exception{
    private int i;
    private int j;

    public MyArrayDataException(String message, int i, int j){
        super(message + " index i = " + i +", index j = " + j);
        this.i = i;
        this.j = j;
    }
}
