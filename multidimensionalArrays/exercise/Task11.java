package javaAdvanced.multidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        for (int col = cols - 1; col >= 0; col--) {
            int colToPrint = col;
            for (int row = rows - 1; row > rows - 1 - (cols - col) && row >= 0; row--) {
                System.out.print(matrix[row][colToPrint] + " ");
                colToPrint++;
            }
            System.out.println();

            if (col == 0) {
                for (int row = rows - 2; row >= 0; row--) {
                    colToPrint = 0;
                    for (int rowToPrint = row; rowToPrint >= 0 && colToPrint < cols; rowToPrint--) {
                        System.out.print(matrix[rowToPrint][colToPrint] + " ");
                        colToPrint++;
                    }
                    System.out.println();

                }
            }
        }
    }
}
