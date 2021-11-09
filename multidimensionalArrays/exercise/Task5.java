package javaAdvanced.multidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];
        fillMatrix(scanner, matrix, rows, cols);

        String commandline = scanner.nextLine();

        while (!commandline.equals("END")) {

            if (!validateCommand(commandline, rows, cols)) {
                System.out.println("Invalid input!");
            } else {
                String[] command = commandline.split(" ");
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);
                String element1 = matrix[row1][col1];
                String element2 = matrix[row2][col2];
                matrix[row1][col1] = element2;
                matrix[row2][col2] = element1;

                printMatrix(matrix, rows, cols);
            }
            commandline = scanner.nextLine();
        }



    }

    private static boolean validateCommand(String command, int rows, int cols) {
        //swap 0 0 1 1
        String [] tokens = command.split(" "); //["swap", "0", "0", "1", "1"]
        // 1. команда swap
        String commandName = tokens[0];
        if (!commandName.equals("swap")) {
            return false;
        }
        //2. брой на координати
        if(tokens.length != 5) {
            return false;
        }
        // 3. коордианти
        int rowFirst = Integer.parseInt(tokens[1]);
        int colFirst = Integer.parseInt(tokens[2]);
        int rowSecond = Integer.parseInt(tokens[3]);
        int colSecond =Integer.parseInt(tokens[4]);

        if(rowFirst < 0 || rowFirst >= rows || colFirst < 0 ||
                colFirst >= cols || rowSecond < 0 || rowSecond >= rows || colSecond < 0 || colSecond >= cols) {
            return false;
        }

        return true;


    }

    private static void fillMatrix(Scanner scanner, String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    public static void printMatrix (String [][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
