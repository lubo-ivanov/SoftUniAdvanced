package javaAdvanced.multidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = createMatrix("\\s+", scanner);

        int mainDiagonal = getMainDiagonal(matrix);
        int secondaryDiagonal = getSecondaryDiagonal(matrix);
        System.out.println(Math.abs(mainDiagonal - secondaryDiagonal));


    }

    private static int getSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix.length -1 - i];
        }
        return sum;
    }

    private static int getMainDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] createMatrix(String separator, Scanner scanner) {
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][rows];
        for (int row = 0; row < rows; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(separator)).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }
        return matrix;
    }
}
