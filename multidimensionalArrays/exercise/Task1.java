package javaAdvanced.multidimensionalArrays.exercise;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String type = input[1];
        switch (type) {
            case "A":
                printMatrix(fillTypeA(size));
                break;
            case "B":
                printMatrix(fillTypeB(size));
                break;
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillTypeA(int size) {
        int number = 1;
        int[][] matrix = new int[size][size];
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = number++;
            }
        }
        return matrix;
    }

    private static int[][] fillTypeB(int size) {
        int number = 1;
        int[][] matrix = new int[size][size];
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = number++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = number++;
                }
            }

        }
        return matrix;
    }
}
