package Lesson_03;

import java.util.Random;
import java.util.Scanner;

public class HomeWork_01_03 {

    public static void main(String[] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        guessNumber(random, scanner);

        String[] words = {"apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        guessWord(words, random, scanner);
    }

    static private void guessNumber(Random rand, Scanner sc) {
        int an;
        do {
            int x = rand.nextInt(10);
            int i;
            int j = 0;
            boolean win = false;
            System.out.println("Я загадал число, попробуй угадать!");
            System.out.print("Твой ответ: ");
            do {
                i = sc.nextInt();
                if(i == x) {
                    System.out.println("Молодец! Угадал!");
                    win = true;
                    break;
                } else {
                    j++;
                    System.out.println(x>i ? "Загаданное число больше." : "Загаданное число меньше." );
                }
            } while (j<3);
            if(!win) {
                System.out.printf("Ты проигралл, было загаднно число %d\n", x);
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            an = sc.nextInt();
        } while (an == 1);
    }

    static private boolean compareWords(String word1, String word2){
        if(word1.length() != word2.length()){
            return false;
        }
        for (int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    static private void guessWord(String[] mass, Random rand, Scanner sc){
        int x = rand.nextInt(mass.length);
        String word = mass[x];
        System.out.println("Я загадал слово, попробуй угадать!");
        System.out.print("Твой ответ: ");
        String answ = sc.next();
        // Так как в условии не сказано, что выводить надо все до этого совпавшие буквы, будем выводить только текущего слова
        // Иначе просто добавим новую переменную для хранения слова подсказки с симовлом #
        do {
            if(compareWords(word, answ)) {
                System.out.println("Молодец! Угадал!");
                break;
            } else {
                for (int i = 0; i < 15; i++) {
                    boolean flag = false;
                    if(i<word.length()) {
                        for (int j = 0; j < answ.length(); j++) {
                            if(word.charAt(i) == answ.charAt(j)){
                                System.out.print(answ.charAt(j));
                                flag = true;
                                break;
                            }
                        }
                        if(!flag) {
                            System.out.print("#");
                        }
                    } else System.out.print("#");
                }
                System.out.println("");
                answ = sc.next();
            }
        } while (true);

    }
}
