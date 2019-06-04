package Lesson_02;

// Для вывода массива на экран
import java.util.Arrays;

public class HomeWork_01_02 {

    static public void main(String[] args){

        // Так как явно не указано, но до этого говорилось, что каждую задачу делать
        // отдельным методом, то зададим массив в основном main методе, а логику сделаем в другом
        int[] array_01 = {0,0,0,1,0,1,0,1,0,1,0};
        System.out.println(Arrays.toString(array_01));
        reverseBit(array_01);
        System.out.println(Arrays.toString(array_01));

        int[] array_02 = new int[8];
        initArray(array_02);
        System.out.println(Arrays.toString(array_02));

        int[] array_03 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array_03));
        changeSmallNumber(array_03);
        System.out.println(Arrays.toString(array_03));

        int[][] array_04 = new int[7][7];
        // Так как по умолчанию int инициализируется 0, то доп действий не надо
        // Используем доп метод для вывода матрицы
        printMatrix(array_04);
        //System.out.println(Arrays.toString(array_04));
        initDiagonals(array_04);
        //System.out.println(Arrays.toString(array_04));
        printMatrix(array_04);

        int[] array_05 = {10, 3 , 5, -2, 6, 12, 8, 9, 11};
        System.out.println(Arrays.toString(array_05));
        findExtremes(array_05);

        int[] array_06 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(array_06));
        int[] array_06_1 = {1, 1, 1,  2, 1};
        System.out.println(checkBalance(array_06_1));
        int[] array_06_2 = {1, 1, 1, 1,  2, 1};
        System.out.println(checkBalance(array_06_2));

        int n = -11;
        int[] array_07 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(Arrays.toString(array_07));
        moveElements(array_07, n);
        System.out.println(Arrays.toString(array_07));
        moveElements(array_07, 13);
        System.out.println(Arrays.toString(array_07));
    }

    // Так как массив - ссылочный тип данных, то ничего не надо возвращать, все прпвится по ссылке
    static private void reverseBit(int[] ar){
        for (int i = 0; i < ar.length; i++) {
            if(ar[i] == 1) {
                ar[i] = 0;
            }
            else {
                ar[i] = 1;
            }
        }
    }

    static private void initArray(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            ar[i] = i*3;
        }
    }

    static private void changeSmallNumber(int[] ar){
        for (int i = 0; i < ar.length; i++) {
            if(ar[i]<6) {
                ar[i] = ar[i] * 2;
            }
        }
    }

    // Вспомогательный метод для вывода матрицы
    static private void printMatrix(int[][] ar){
        for (int[] i: ar) {
            for (int j: i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static private void initDiagonals(int[][] ar){
        // Так как массив квадратный, то второе число равно первому
        for (int i = 0; i < ar.length; i++) {
            ar[i][i] = 1;
            ar[i][ar.length-1-i] = 1;
        }
    }

    static private void findExtremes(int[] ar){
        int max = 0, min = 0;
        for (int i: ar) {
            if(i > max) max = i;
            if(i < min) min = i;
        }
        System.out.println("Минимум равен " + min + ", максимум равен " + max);
    }

    static private boolean checkBalance(int[] ar){
        int cycles = ar.length - 1;
        for (int i = 0; i < cycles; i++) {
            int sumL = 0, sumR = 0;
            for (int j = 0; j < i; j++) {
                sumL += ar[j];
            }
            for (int j = i; j < ar.length; j++) {
                sumR += ar[j];
            }
            if(sumL == sumR) {
                return true;
            }
        }
        return false;
    }

    static private void moveElements(int[] ar, int n){
        // Если число положительное, то сдвиг вправо
        if(n>0){
            // Для исключения лишних движений, если n равно длине массива, то исходный массив равен измененному,
            // то есть можно исключить целое число длин массивов и смещать только на остаток
            int k = n % ar.length;
            for (int i = 0; i < k; i++) {
                int m = ar[ar.length-1];
                for (int j = ar.length-1; j > 0; j--) {
                    ar[j] = ar[j-1];
                }
                ar[0] = m;
            }
        // если отрицательное, то влево
        } else {
            int k = n % ar.length;
            for (int i = 0; i > k ; i--) {
                int m = ar[0];
                for (int j = 0; j < ar.length-1; j++) {
                    ar[j] = ar[j+1];
                }
                ar[ar.length-1] = m;
            }
        }
    }
}
