package HW4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку.
 * 2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
 * 3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
 * 4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
 */
public class TicTacToe {
    public static final int DIMENTION = 3; //размерность доски
    public static final int winSeq = 3;    //количество в ряд, для победы
    public static final char charX = 'X';  // метка игрока
    public static final char charO = 'O';  //метка компьютера
    public static final char charN = '-';  //пустое поле
    public static char[][] map;


    public static void main(String[] args) {
        map = new char[DIMENTION][DIMENTION];
        fillMap();
        drawMap();
        boolean humanMove = true;
        while (!gameOver()) {
            if (humanMove) doHumanMove();
            else doIAmove();
            drawMap();
            humanMove = !humanMove;
        }
    }

    private static void doIAmove() {
        Random random = new Random();
        int X, Y;
        do {
            X = random.nextInt(DIMENTION);
            Y = random.nextInt(DIMENTION);
        } while (!isPlaceFree(X, Y) && !isHumanNear(X, Y));
        map[Y][X] = charO;
        System.out.println("ход компьютера:");
    }


    public static void doHumanMove() {
        System.out.print("Введите координаты в формате X Y: ");
        int[] coordinates = getCoords();
        int X = coordinates[0];
        int Y = coordinates[1];
        if (isMovePossible(X, Y))
            map[Y][X] = charX;
        else {
            System.out.println("Неверные координаты");
            doHumanMove();
        }
    }


    static void fillMap() {
        for (int i = 0; i < DIMENTION; i++) {
            Arrays.fill(map[i], charN);
        }

    }

    static void drawMap() {
        int row = 0;
        while (row < DIMENTION) {
            drawRow(row);
            row++;
        }
    }

    static void drawRow(int row) {
        int col = 0;
        while (col < DIMENTION - 1) {
            System.out.print(map[row][col] + "|");
            col++;
        }
        System.out.println(map[row][col]);
    }

    static boolean isMovePossible(int X, int Y) {
        return X >= 0 && X < DIMENTION && Y >= 0 && Y < DIMENTION && isPlaceFree(X, Y);
    }

    static boolean isPlaceFree(int X, int Y) {
        return map[Y][X] == charN;
    }

    static boolean gameOver() {
        if (isWinnableSequence(charO)) {
            System.out.println("Компьютер победил, жалкий человек.");
            return true;
        } else if (isWinnableSequence(charX)) {
            System.out.println("Вы победили!!!");
            return true;
        } else if (!isMapPlayable()) {
            System.out.println("Ничья");
            return true;
        }
        return false;

    }

    private static boolean isMapPlayable() {
        for (int i = 0; i < DIMENTION; i++) {
            for (int j = 0; j < DIMENTION; j++) {
                if (map[i][j] == charN) return true;
            }
        }
        return false;
    }

    static boolean isWinnableSequence(char c) {
        return isLineWin(c, 'R') || isLineWin(c, 'C') || isDiagonalWin(c);
    }

    //orientation 'R' - row, 'C' - col
    static boolean isLineWin(char player, char orientation) {
        int sum;
        int index;
        // lines
        for (int line = 0; line < DIMENTION; line++) {
            index = 0;
            while ((DIMENTION - index) >= winSeq) {
                sum = 0;
                //orientation 'R' - row, 'C' - col
                //сложное условие для указания циклу искать по строкам или столбцам
                while (index < DIMENTION && (orientation == 'C' ? map[index][line] : map[line][index]) == player) {
                    sum++;
                    if (sum == winSeq) return true;
                    index++;
                }
                index++;
            }
        }
        return false;
    }

    static boolean isDiagonalWin(char c) {
        return checkLeftDiagonals(c) || checkRightsDiagonals(c);
    }

    static boolean checkLeftDiagonals(char c) {
        int tempRow, tempCol, sum;
        for (int row = 0; row < DIMENTION; row++) {
            for (int col = 0; col < DIMENTION; col++) {
                sum = 0;
                tempRow = row;
                tempCol = col;
                while (tempRow < DIMENTION && tempCol < DIMENTION && map[tempRow][tempCol] == c) {
                    sum++;
                    if (sum == winSeq) return true;
                    tempRow++;
                    tempCol++;
                }
            }
        }
        return false;
    }


    static boolean checkRightsDiagonals(char c) {
        int tempRow, tempCol, sum;
        for (int row = 0; row < DIMENTION; row++) {
            for (int col = DIMENTION - 1; col >= 0; col--) {
                sum = 0;
                tempRow = row;
                tempCol = col;
                while (tempRow < DIMENTION && tempCol >= 0 && map[tempRow][tempCol] == c) {
                    sum++;
                    if (sum == winSeq) return true;
                    tempRow++;
                    tempCol--;
                }
            }
        }
        return false;
    }

    static boolean isHumanNear(int X, int Y) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (isMovePossible(i + X, j + Y))
                    if (map[Y + j][X + i] == charX) return true;
            }
        }
        return false;
    }

    static int[] getCoords() {
        Scanner reader = new Scanner(System.in);
        int[] coordinates = {-1, -1};
        if (reader.hasNextInt()) coordinates[0] = reader.nextInt();
        if (reader.hasNextInt()) coordinates[1] = reader.nextInt();
        return coordinates;
    }

}