package javaAdvanced.multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = createMatrix(rows, cols, "\\s+", scanner);
        char[][] secondMatrix = createMatrix(rows, cols,  "\\s+", scanner);

        char[][] comparedMatrix = compareMatrices (firstMatrix, secondMatrix);
        printMatrix(comparedMatrix);

    }

    private static void printMatrix(char[][] comparedMatrix) {
        for (int row = 0; row < comparedMatrix.length; row++) {
            for (int col = 0; col < comparedMatrix[0].length; col++) {
                System.out.print(comparedMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] compareMatrices(char[][] firstMatrix, char[][] secondMatrix) {
        char[][] comparedMatrix = new char[firstMatrix.length][firstMatrix[0].length];
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[0].length; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    comparedMatrix[row][col] = firstMatrix[row][col];
                } else {
                    comparedMatrix[row][col] = '*';
                }
            }
        }
        return comparedMatrix;
    }

    private static char[][] createMatrix(int rows, int cols, String separator, Scanner scanner) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] currentRow = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = currentRow[col].charAt(0);
            }
        }
        return matrix;
    }
}
