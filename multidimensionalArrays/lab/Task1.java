package javaAdvanced.multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String separator = "\\s+";

        int[][] firstMatrix = createMatrix(separator, scanner);

        int[][] secondMatrix = createMatrix(separator, scanner);

        if (equalMatrices(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    private static boolean equalMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (!sizeMatches(firstMatrix, secondMatrix)) {
            return false;
        } else {
            for (int row = 0; row < firstMatrix.length; row++) {
                for (int col = 0; col < firstMatrix[row].length; col++) {
                    if (firstMatrix[row][col] != secondMatrix[row][col]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean sizeMatches(int[][] firstMatrix, int[][] secondMatrix) {
        return firstMatrix.length == secondMatrix.length && firstMatrix[0].length == secondMatrix[0].length;
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
