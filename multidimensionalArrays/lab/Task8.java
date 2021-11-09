package javaAdvanced.multidimensionalArrays.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = createMatrix("\\s+", scanner);

        int[] wrongValueIndexes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int wrongValue = matrix[wrongValueIndexes[0]][wrongValueIndexes[1]];
        List<int[]> newValuesList = findNewValues(matrix, wrongValue);
        assignNewValues(matrix, newValuesList);
        printMatrix(matrix);



    }

    private static void printMatrix(int[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[0].length; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }


    private static void assignNewValues(int[][] matrix, List<int[]> newValuesList) {
        for (int[] values: newValuesList) {
            matrix[values[0]][values[1]] = values[2];
        }
    }

    private static List<int[]> findNewValues (int[][] matrix, int wrongValue) {
        List<int[]> newValuesList = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    newValuesList.add(new int[]{row, col, newValue(matrix, row, col, wrongValue)});
                }
            }
        }
        return newValuesList;
    }

    private static int newValue(int[][] matrix, int row, int col, int wrongValue) {
        int newValue = 0;
        if (row - 1 >= 0 && matrix[row - 1][col] != wrongValue) {
            newValue += matrix[row - 1][col];
        }
        if (col - 1 >= 0 && matrix[row][col - 1] != wrongValue) {
            newValue += matrix[row][col - 1];
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] != wrongValue) {
            newValue += matrix[row + 1][col];
        }
        if (col + 1 < matrix[0].length && matrix[row][col + 1] != wrongValue) {
            newValue += matrix[row][col + 1];
        }
        return newValue;
    }


    private static int[][] createMatrix(String separator, Scanner scanner) {
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(separator)).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }
        return matrix;
    }
}
