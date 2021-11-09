package javaAdvanced.multidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = createMatrix("\\s+", scanner);

        printBestSubmatrix (matrix, findBestSum(matrix));


    }

    private static void printBestSubmatrix(int[][] matrix, int[] bestSum) {
        System.out.println("Sum = " + bestSum[0]);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[bestSum[1] + i][bestSum[2] + j] + " ");
            }
            System.out.println();
        }
    }

    private static int[] findBestSum(int[][] matrix) {
        int[] bestSum = new int[]{0, 0, 0};
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[0].length - 2; col++) {
                int sum = findSumOfSubmatrix(matrix, row, col);
                if (sum > bestSum[0]){
                    bestSum = new int[]{sum, row, col};
                }
            }
        }
        return bestSum;
    }

    private static int findSumOfSubmatrix(int[][] matrix, int row, int col) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum += matrix[row + i][col + j];
            }
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
