package Lesson_2;

class MyArraySizeException extends Exception {
    private int maxSize;

    MyArraySizeException(String message, int size){
        super(message + ", " + size);
        this.maxSize = size;
    }

}
