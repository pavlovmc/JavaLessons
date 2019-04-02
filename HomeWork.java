package Java_01.Lesson_01;

public class HomeWork {

    public static void main(String[] args){
        /*
        Строки с опредлением пройденных элементарных типов.
        Сделал по памяти, может что-то и упустил.
        Старался по максимуму использовать все переменные.
         */

        // integer types
        byte firstByteValue = 5;
        short secondShortValue = 777;
        int thirdIntValue = 100500;
        long forthLongValue = 115003334L;

        // float point types
        float fifthFloatValue = 4.2f;
        double sixthDoubleValue = 764.2;

        // other types
        boolean seventhBoolValue = false;
        char eththCharValue = 'V';
        String ninthStringValue = "Владимир";
        Integer tenthIntegerValue = -3;

        double firstResult = getFunctionResult((double) fifthFloatValue, sixthDoubleValue,
                (double)forthLongValue, (double)thirdIntValue);
        System.out.println("Результат функции равен " + firstResult);

        System.out.println("Сумма чисел " + (checkSum((double)firstByteValue, (double)secondShortValue)
                ? "в диапазоне от 10 до 20 "
                : "не в диапазоне от 10 до 20"));

        checkPositivity(firstByteValue);

        seventhBoolValue = checkNegativity(tenthIntegerValue);
        // Следущий вызов просто печает результат предыдущего вызова, в задании явно не указано что делать
        System.out.println("checkNegativity return " + seventhBoolValue);

        printHelloMessage(ninthStringValue);

        // Провряем на разном набор лет
        checkYear(2000);
        checkYear(1900);
        checkYear(2001);
        checkYear(2004);
    }

    // Так как явно не указаны целые числа, то считаем что может быть не целое
    static private double getFunctionResult(double a, double b, double c, double d){
        return a*(b+(c/d));
    }

    // Так как явно не указаны целые числа, то считаем что может быть не целое
    static private boolean checkSum(double a, double b){
        double c = a + b;
        if(c>=10 && c<=20)
            return true;
        else
            return false;
    }

    static private void checkPositivity(int a){
        System.out.println(a>=0 ? "Число положительное": "Число отрицательное");
    }

    static private boolean checkNegativity(int a){
        if(a<0)
            return true;
        else
            return false;
    }

    static private void printHelloMessage(String name){
        System.out.println("Првиет, " + name);
    }

    static private void checkYear(int year){
        if(year % 4 != 0){
            System.out.println(year + " год не високосный");
        }
        else if((year % 100 == 0) && (year % 400 != 0)) {
            System.out.println(year + " год не високосный");
        }
        else
            System.out.println(year + " год високосный");
    }
}
