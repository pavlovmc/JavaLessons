package Lesson_04;

import java.util.Random;
import java.util.Scanner;

public class HomeWork_01_04 {

    static private char PLAYER_DOT = 'X';
    static private char CPU_DOT = 'O';
    static private char EMPTY_DOT = '.';

    // Для обычной игры
    static private int SIZE_X = 3;
    static private int SIZE_Y = 3;

    static private Scanner scanner = new Scanner(System.in);
    static private Random random = new Random();

    static public void main(String[] args){
        standardGame();
    }

    static private void standardGame(){
        char[][] standardField = new char[SIZE_X][SIZE_Y];
        boolean win;
        initField(standardField);
        printField(standardField);
        do {
            playerTurn(standardField);
            printField(standardField);
            win = checkWinner(standardField, PLAYER_DOT);
            if(win){
                System.out.println("Ты выиграл!");
                break;
            }
            if(isFull(standardField)) {
                break;
            }
            cpuTurn(standardField);
            printField(standardField);
            win = checkWinner(standardField, CPU_DOT);
            if(win){
                System.out.println("Компьютер выиграл!");
                break;
            }
        } while (!isFull(standardField));
        if(!win) {
            System.out.println("Ничья!");
        }

    }

    static private boolean isFull(char[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == EMPTY_DOT){
                    return false;
                }
            }
        }
        return true;
    }

    static private void initField(char[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = EMPTY_DOT;
            }
        }
    }

    static private void printField(char[][] arr){
        System.out.print("_|");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i+1 + "|");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i+1 + "|");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "|");
            }
            System.out.println();
        }
    }

    // Так как игровое поле может быть не стандартным, то его мы тоже хотим получить в метод
    static private boolean checkCell(int x, int y, char[][] arr){
        if(x<0 || x>arr.length || y<0 || y>arr[0].length){
            return false;
        }
        return arr[x][y] == EMPTY_DOT;
    }

    static private void playerTurn(char[][] arr){
        System.out.println("Ходит игрок, введи координаты X и Y:");
        int x = scanner.nextInt()-1;
        int y = scanner.nextInt()-1;
        while (!checkCell(x, y, arr)) {
            System.out.println("Координата занята или неверная, введи координаты X и Y:");
            x = scanner.nextInt()-1;
            y = scanner.nextInt()-1;
        }
        arr[x][y] = PLAYER_DOT;
    }

    static private void cpuTurn(char[][] arr){
        System.out.println("Ходит компьютер");
        int x = random.nextInt(arr.length);
        int y = random.nextInt(arr[0].length);
        while (!checkCell(x, y, arr)) {
            x = random.nextInt(arr.length);
            y = random.nextInt(arr[0].length);
        }
        arr[x][y] = CPU_DOT;
    }

    static private boolean checkWinner(char[][] arr, char sym){
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == sym)
                    sum++;
            }
            if(sum == 3) {
                return true;
            }
        }
        for (int i = 0; i < arr[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j][i] == sym)
                    sum++;
            }
            if(sum == 3) {
                return true;
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i][i] == sym){
                sum++;
            }
            if(sum == 3) {
                return true;
            }
        }
        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i][arr.length - i - 1] == sym){
                sum++;
            }
            if(sum == 3) {
                return true;
            }
        }
        return false;
    }
}
