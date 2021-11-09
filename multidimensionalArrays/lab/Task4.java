package javaAdvanced.multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String separator = ", ";

        int[][] matrix = createMatrix(separator, scanner);

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(Arrays.stream(matrix).flatMapToInt(Arrays::stream).sum());

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
