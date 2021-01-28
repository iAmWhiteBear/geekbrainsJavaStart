package HW1;

import java.util.Calendar;

/**
 * 1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
 * 2. Создать переменные всех пройденных типов данных и инициализировать их значения.
 * 3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат, где a, b, c, d – аргументы этого метода, имеющие тип float.
 * 4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
 * 5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
 * 6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
 * 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
 * 8. * Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
 */
public class Start {
    public static void main(String[] args) {
        byte b = 127;
        byte bb = 10;
        char c = 'b';
        int N = 2000000;
        float f = 34.9f;
        double d = 1000.1;
        boolean Booooo = true;
        String s = "Hello world!";


        // испытания методов
        System.out.println(multiCalc(2,3,4,6)); //  7.(3)
        System.out.println(between10and20( b, bb));
        isPositive(-5);
        System.out.println(isNegative(0));
        sayHello("Андрей");
        leapYear(2000);
        leapYear(2021);

    }


    static float multiCalc(float a,float b,float c,float d){
        return (a*(b+(c/d)));
    }


    static boolean between10and20(byte first, byte second){
        byte sum = (byte) (first + second);
        return (sum >= 10 && sum <=20);
    }

    static void isPositive(int x){
        if(x>0) System.out.println("это число положительное");
        else System.out.println("это число отрицательное");
    }

    static boolean isNegative(int x){
        return x<0;
    }

    static void sayHello( String name){
        // https://www.youtube.com/watch?v=hR_g_tC5Zmo
        System.out.printf("Привет, %s!%n", name);
    }

    static void leapYear(int year) {
        //в конце концов оно не обязательное, и я в интернете нашёл замечательное решение
        //зачем считать года, когда можно считать дни.
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        if (cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365) System.out.println("Этот год високосный");
        else System.out.println("Этот год обычный");
    }

}

