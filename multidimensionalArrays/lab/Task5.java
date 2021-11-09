package javaAdvanced.multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String separator = ", ";
        int[][] matrix = createMatrix(separator, scanner);
        int [] findBiggestSum = findBiggestSum(matrix);

        printBiggestMatrix (matrix, findBiggestSum);
        System.out.println(findBiggestSum[2]);
    }

    private static void printBiggestMatrix(int[][] matrix, int[] findBiggestSum) {
        int row = findBiggestSum[0];
        int col = findBiggestSum[1];
        System.out.println(matrix[row][col] + " " + matrix[row][col+1]);
        System.out.println(matrix[row + 1][col] + " " + matrix[row + 1][col+1]);
    }


    private static int[] findBiggestSum(int[][] matrix) {
        int[] biggestIndex = new int[3];
        int biggestSum = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[0].length - 1; col++) {
                int sum = matrix[row][col]
                        + matrix[row][col + 1]
                        + matrix[row + 1][col]
                        + matrix[row + 1][col + 1];
                if (sum > biggestSum) {
                    biggestSum = sum;
                    biggestIndex[0] = row;
                    biggestIndex[1] = col;
                    biggestIndex[2] = sum;
                }
            }
        }
        return biggestIndex;
    }


    private static int[][] createMatrix(String separator, Scanner scanner) {
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(separator)[0]);
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(separator)).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }
        return matrix;
    }
}
