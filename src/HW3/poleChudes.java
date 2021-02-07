package HW3;

import java.util.Random;
import java.util.Scanner;

/**
 * 2. * Создать массив из слов
 *
 * String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
 * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
 * сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
 * Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
 * apple – загаданное
 * apricot - ответ игрока
 * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
 * Для сравнения двух слов посимвольно можно пользоваться:
 * String str = "apple";
 * char a = str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
 * Играем до тех пор, пока игрок не отгадает слово.
 * Используем только маленькие буквы.
 */

public class poleChudes implements Runnable {
    private char[] wordArray;
    private char[] mask;
    private  String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    private String word;
    private Scanner reader;
    private int openLetters;

    public poleChudes() {
        init();
    }

    //стартовая инициация переменных
    public void init(){
        Random random = new Random();
        reader = new Scanner(System.in);
        int newWordPosition = random.nextInt(words.length);
        word = words[newWordPosition];
        wordArray = word.toCharArray();
        mask = "###############".toCharArray();
        openLetters = 0;
        System.out.println("Новое слово загадано.");
    }

    @Override
    public void run(){
        //угадывание слова
        System.out.println("Попробуйте угадать его.");
        String playerAns = reader.nextLine().toLowerCase();
        //цикл игры
        while (!playerAns.equals(word)){
            drawMask(playerAns);
            //проверка если угадывание было по буквам
            if (openLetters==wordArray.length) break;
            playerAns = reader.nextLine().toLowerCase();
        }
        // конец игры
        System.out.println("Угадали!!!!!");
    }

    //подстановка угаданных букв и отрисовка маски
    private void drawMask(String playerAns) {
        char[] temp = playerAns.toCharArray();
        //сделать минимальное из двух чтобы предотвратить выход из любого массива.
        int cicleLen = Math.min(temp.length, wordArray.length);
        for (int i = 0; i < cicleLen; i++)
            if (temp[i]==wordArray[i])
                if (mask[i] == '#') {
                    mask[i]=temp[i];
                    openLetters++;
                }
        //печать маски с буквами
        System.out.println(new String(mask));
    }
}
