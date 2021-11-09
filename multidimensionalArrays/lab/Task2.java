package javaAdvanced.multidimensionalArrays.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = createMatrix("\\s+", scanner);
        int number = Integer.parseInt(scanner.nextLine());
        if (!numberPresent(matrix,number).isEmpty()) {
            numberPresent(matrix, number).forEach(element-> System.out.println(element[0] + " " + element[1]));
        } else {
            System.out.println("not found");
        }
    }

    private static List<int[]> numberPresent(int[][] matrix, int number) {
        List<int[]> positions = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == number) {
                        positions.add(new int[] {row, col});
                    }
                }
            }
        return positions;
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
