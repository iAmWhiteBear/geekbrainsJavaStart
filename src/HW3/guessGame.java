package HW3;

import java.util.Random;
import java.util.Scanner;


/**
 * * 1. Написать программу, которая загадывает случайное число от 0 до 9
 * и пользователю дается 3 попытки угадать это число.
 * При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
 * После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 */


public class guessGame {
    private int intents = 3;
    private final int difficulty;

    public guessGame() {
        difficulty = 9;
    }

    public guessGame(int difficulty) {
        this.difficulty = difficulty;
    }
    
    public void startGame(){
        Random random = new Random();
        int number;
        int answer;
        do{
            //генерируется новое число
            System.out.printf("Угадайте число от 0 до %d%n",difficulty);
            number = random.nextInt(difficulty+1);
            //цикл для отгадывания
            for (int i = intents; i > 0; i--) {
                answer = getIntConsole();
                if ( answer == number) {
                    System.out.println("Поздравляем, вы угадали!!!!!!!!!!!!!!!!!!!!");
                    break;
                }
                if (i>1){
                    if(answer < number ) System.out.println("больше");
                    else System.out.println("меньше");
                    System.out.printf("Количество оставшихся попыток: %d%n",i-1);
                }
                else System.out.println("К сожалению вы не отгадали. Загаданное число было: "+number);
            }
            System.out.println();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        }while (getIntConsole()==1);
    }

    /**
     я не знаю, надо-ли делать контроль ошибок,
     но я подумал, что лучше пусть будет.
     */
    static int getIntConsole(){
        Scanner reader = new Scanner(System.in);
        int num;
        if (reader.hasNextInt()) num = reader.nextInt();
        else {
            System.out.print("ввод некоррректный, введите другое число");
            num = getIntConsole();
        }
        return num;
    }
}
