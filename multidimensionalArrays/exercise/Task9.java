package javaAdvanced.multidimensionalArrays.exercise;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];
        String command = scanner.nextLine();
        while (!command.equals("stop")) {
            String[] commandLine = command.split("\\s+");
            int entryRow = Integer.parseInt(commandLine[0]);
            int desiredRow = Integer.parseInt(commandLine[1]);
            int desiredCol = Integer.parseInt(commandLine[2]);
            int distance = Math.abs(desiredRow - entryRow) + 1;
            boolean foundEmptySpot = false;
            if (checkIfEmpty(matrix, desiredRow, desiredCol)) {
                matrix[desiredRow][desiredCol] = 1;
                foundEmptySpot = true;
            } else {
                int[] stats = findEmptySpot(matrix, desiredRow, desiredCol);
                if (stats[1] == 1) {
                    foundEmptySpot = true;
                    desiredCol = stats[0];
                    matrix[desiredRow][desiredCol] = 1;
                }
            }
            if (foundEmptySpot) {
                distance += desiredCol;
                System.out.println(distance);
            } else {
                System.out.printf("Row %d full%n", desiredRow);
            }

            command = scanner.nextLine();
        }


    }

    private static int[] findEmptySpot(int[][] matrix, int desiredRow, int desiredCol) {
        int[] stats = new int[]{desiredCol, 0};
        int start = desiredCol;
        int i = -1;
        desiredCol--;
        boolean outsideOnce = false;
        while (desiredCol < matrix[0].length / 2 + Math.abs(matrix[0].length / 2 + start)) {
            if (desiredCol > 0 && desiredCol < matrix[0].length) {
                if (matrix[desiredRow][desiredCol] == 0) {
                    stats[0] = desiredCol;
                    stats[1] = 1;
                    break;
                }
                if (outsideOnce) {
                    i = -(Math.abs(i) + 1) * i / Math.abs(i);
                    desiredCol = desiredCol + i;
                }
            } else {
                if (outsideOnce) {
                    break;
                }
                outsideOnce = true;
            }

            i = -(Math.abs(i) + 1) * i / Math.abs(i);
            desiredCol = desiredCol + i;
        }
        return stats;
    }

    private static boolean checkIfEmpty(int[][] matrix, int desiredRow, int desiredCol) {
        return matrix[desiredRow][desiredCol] == 0;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

