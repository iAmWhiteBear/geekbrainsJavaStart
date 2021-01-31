package HW2;

import java.util.Arrays;

/**
 * 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
 * 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
 * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
 * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
 * 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
 * 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
 * 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
 */

public class lesson2 {

    public static void main(String[] args) {
        int[] array1 = {0,1,1,1,1,0,1,0,1,1,0,0,0,1,0,1,0};
        int[] array2 = new int[8];
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int[] array5 = {5,7,2,9,17,1,9,18,3,0,20,19,-1};
        int[] array6 = {2,2,2,1,2,2,10,1};
        int[] array6wrong = {1,1,2,3,1,2,1,5,100,300};
        int[] array7 = {1,2,3,4,5,6,7,8,9,10};

        //test run
        //1
        invertElements(array1);
        System.out.println("задача 1:"+Arrays.toString(array1));
        //2
        fillArrayByMulti3(array2);
        System.out.println("задача 2:"+Arrays.toString(array2));
        //3
        doubleLessThen6(array3);
        System.out.println("задача 3:"+Arrays.toString(array3));
        //4
        System.out.println("задача 4:");
        printMatrix(initMatrix(8));
        //5
        System.out.println("массив для поиска максимального и минимального значения: "+Arrays.toString(array5));
        sayMinMax(array5);
        //6
        System.out.println("задача 6: "+isInBalance(array6));
        System.out.println("задача 6: "+isInBalance(array6wrong));
        //7
//        shift(array7,2);
//        printArray(array7);
//        shift(array7,-5);
//        printArray(array7);
        shift(array7,11);
        System.out.println(Arrays.toString(array7));

    }

    // 1
    /**1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;*/
    static void invertElements(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i]==1)?0:1;
        }
    }

    // 2
    /** 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;*/
    static void fillArrayByMulti3(int[] template){
        for (int i = 0; i < template.length; i++) {
            template[i] = i*3;
        }
    }

    //3
    /** 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;*/
    static void doubleLessThen6(int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i]<6) array[i] = 2*array[i];
        }
    }

    //4
    /**4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и с помощью цикла(-ов) заполнить его диагональные элементы единицами;*/
    static int[][] initMatrix(int side){
        int[][] matrix = new int[side][side];
        for (int i = 0; i < side; i++) {
                matrix[i][i] = 1;
                matrix[i][side-1-i] = 1;
        }
        return matrix;
    }

    //5*
    /**5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);*/
    static void sayMinMax(int[] array){
        int min = array[0];
        int max = array[0];
        for (int j : array) {
            min = Math.min(j, min);
            max = Math.max(j, max);
        }
        System.out.println("Минимальное значение в массиве: " + min);
        System.out.println("Максимальное значение в массиве: " + max);
    }

    //6**
    /**6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
     *  если в массиве есть место, в котором сумма левой и правой части массива равны.
     *  Примеры:
     *  checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
     *  checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
     */
    static boolean isInBalance(int[] array){
        int sum = 0;
        int left = 0;
        boolean result = false;
        for (int element : array) sum+=element;
        //если это две части одного массива и они равны, значит сумма их точно будет чётной
        if (sum % 2 != 0) return result;
        // суммирую левую часть, до тех пор пока не будет половина, или не превысит её.
        int half = sum/2;
        for (int i : array) {
            left += i;
            if (left > half) break;
            else if (left == half) {
                result = true;
                break;
            }
        }
        return result;
    }

    //7***
    /**7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
     *  при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
     *  Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     *  Примеры:
     *  [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
     *  [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
     *  При каком n в какую сторону сдвиг можете выбирать сами.
     */
    static void shift(int[] array, int n){
        int repeats = Math.abs(n)%array.length; //отрезаю лишнее
        int direction = (n>0)?-1:1; // направление смещения
        int pos, next;    //переменные для обращения к индексам
        int temp;   //переменная буффер
        for (int i = 0; i < repeats; i++) {
            //смещение в сторону направления на 1
            for (int j = 0; Math.abs(j) < array.length-1; j+=direction) {
                // делаю переменных две, что бы не изменять j при отрицательном смещении
                pos = direction+j;
                next = pos+1;
                if (pos < 0) pos = array.length+pos;
                if (next < 0) next = array.length+next;
                if (next >= array.length) next = next-array.length;
                //обмен значений
                temp = array[pos];
                array[pos] = array[next];
                array[next] = temp;
            }
        }
    }



    //for demos
    static void printMatrix(int[][] matrix){
        for (int[] array: matrix){
            for (int element: array) System.out.print(" "+element);
            System.out.println();
        }
    }
}
