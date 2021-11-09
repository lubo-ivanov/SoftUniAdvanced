package javaAdvanced.multidimensionalArrays.lab;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String separator = "\\s+";
        char[][] matrix = createMatrix(separator, scanner);
        findQueen(matrix);

    }

    private static void findQueen(char[][] matrix) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (matrix[row][col] == 'q') {
                    if (validateQueen(matrix, row, col)) {
                        System.out.println(row + " " + col);
                        return;
                    }
                }
            }
        }
    }

    private static boolean validateQueen(char[][] matrix, int row, int col) {
        //check horizontally
        for (int i = 0; i < 8; i++) {
            if (i != col && matrix[row][i] == 'q') {
                return false;
            }
        }
        //check vertically
        for (int i = 0; i < 8; i++) {
            if (i != row && matrix[i][col] == 'q') {
                return false;
            }
        }
        //check first diagonal
        for (int i = -Math.min(row, col); i < 8 - Math.max(row, col); i++) {
            if (i != 0 && matrix[row + i][col + i] == 'q') {
                return false;
            }
        }
        //check second diagonal
        for (int i = -Math.min(row, 7 - col); i < 8 - Math.max(row, 7 - col); i++) {
            if (i != 0 && matrix[row + i][col - i] =='q'){
                return false;
            }
        }
        return true;
    }


    private static char[][] createMatrix(String separator, Scanner scanner) {
        char[][] matrix = new char[8][8];
        for (int row = 0; row < 8; row++) {
            String[] currentRow = scanner.nextLine().split(separator);
            for (int col = 0; col < 8; col++) {
                matrix[row][col] = currentRow[col].charAt(0);
            }
        }
        return matrix;
    }
}
