package javaAdvanced.multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String separator = "\\s+";
        int [][] matrix = createMatrix(separator, scanner);
        
        printDiagonals (matrix);

    }

    private static void printDiagonals(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[matrix.length-1-i][i] + " ");
        }
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
