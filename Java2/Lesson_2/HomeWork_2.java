package Lesson_2;

import static java.lang.Integer.parseInt;

public class HomeWork_2 {

    public static void main (String[] args) {
        String[] s1 = {"1", "1", "1", "1"};
        String[] s2 = {"1", "1", "1", "1"};
        String[] s3 = {"1", "1", "1", "1"};
        String[] s4 = {"1", "к", "1", "1"};
        String[] s5 = {"1", "1", "1", "1", "1"};

        String[][] strArr = {s1, s2, s3, s4};

        int[] sum = summingElements(strArr, 4);

        if (sum[1] == 1){
            System.out.println("Вычисление было прерванно из-за ошибки в данных.");
        }
        else
            System.out.println("Сумма эелементов массива = " + sum[0]);
        System.out.println("Конец вычислений!");
    }

    public static int[] summingElements(String[][] arr, int maxSize) {

        int[] sum = {0,0};
        int[] errPosition = {0, 0};

        try {
            if (arr.length != maxSize)
                throw new MyArraySizeException("Колличество строк массива не соответствует размерности массива равной", arr.length);

            for (int i = 0; i < arr.length; i++) {
                errPosition[0] = i;
                if (arr[i].length != maxSize) {
                    throw new MyArraySizeException("Индекс строки не соответствующей размерности", i);
                }
                for (int j = 0; j < arr[i].length; j++) {
                    errPosition[1] = j;
                    try {
                        if (parseInt(arr[i][j]) % 1 != 0) ;
                    }
                    catch (NumberFormatException e){
                        sum[1] = 1;
                        throw new MyArrayDataException("Элемент массива не соотвуюет целому числу:",i,j);
                    }
                    sum[0] += parseInt(arr[i][j]);
                }
            }
        }

        catch (MyArrayDataException e){
            System.out.println(e.getMessage());
        }
        catch(MyArraySizeException e) {
            System.out.println(e.getMessage() );
        }
        finally {
            System.out.println("Выполняется всегда, при наличии.");
        }
            return sum;
    }
}
