package javaAdvanced.multidimensionalArrays.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        matcher.find();
        int degreesToRotate = Integer.parseInt(matcher.group());

        String command = scanner.nextLine();
        List<String[]> listOfRows = new ArrayList<>();

        while (!command.equals("END")) {
            listOfRows.add(command.split(""));
            command = scanner.nextLine();
        }

        String[][] matrix = createMatrix(listOfRows);

        for (int i = 1; i <= degreesToRotate / 90 % 4; i++) {
            matrix = rotateMatrix(matrix);
        }

        printMatrix(matrix);


    }

    private static String[][] rotateMatrix(String[][] matrix) {
        int rows = matrix[0].length;
        int cols = matrix.length;

        String[][] newMatrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                newMatrix[row][col] = matrix[cols - 1 - col][row];
            }
        }
        return newMatrix;
    }

    private static String[][] createMatrix(List<String[]> listOfRows) {
        int largestRow = listOfRows.stream().mapToInt(element -> element.length).max().getAsInt();
        String[][] matrix = new String[listOfRows.size()][largestRow];
        for (int row = 0; row < listOfRows.size(); row++) {
            for (int col = 0; col < largestRow; col++) {
                if (col >= listOfRows.get(row).length) {
                    matrix[row][col] = " ";
                } else {
                    matrix[row][col] = listOfRows.get(row)[col];
                }
            }

        }
        return matrix;
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
