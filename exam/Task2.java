package javaAdvanced.exam;


import java.util.Scanner;

public class Task2 {
    static int mouseRow;
    static int mouseCol;
    static boolean leftField = false;
    static int cheeseEaten = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = createMatrix(scanner, size);
        findMousePosition(field);

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            moveMouse(field, command);

            if (leftField) {
                System.out.println("Where is the mouse?");
                break;
            }
            checkPosition(field, command);
            command = scanner.nextLine();
        }


        if (!leftField) {
            field[mouseRow][mouseCol] = 'M';
        }
        if (cheeseEaten < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEaten);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
        }

        printMatrix(field);
    }

    private static void checkPosition(char[][] field, String command) {
        if (field[mouseRow][mouseCol] == 'c') {
            field[mouseRow][mouseCol] = '-';
            cheeseEaten++;
        } else if (field[mouseRow][mouseCol] == 'B') {
            field[mouseRow][mouseCol] = '-';
            moveMouse(field, command);
            checkPosition(field, command);
        }

    }

    private static void moveMouse(char[][] field, String command) {
        int currentRow;
        int currentCol;
        switch (command) {
            case "up":
                currentRow = mouseRow - 1;
                currentCol = mouseCol;
                if (!ifInbounds(field, currentRow, currentCol)) {
                    leftField = true;
                } else {
                    mouseRow = currentRow;
                }
                break;
            case "down":
                currentRow = mouseRow + 1;
                currentCol = mouseCol;
                if (!ifInbounds(field, currentRow, currentCol)) {
                    leftField = true;
                } else {
                    mouseRow = currentRow;
                }
                break;
            case "left":
                currentRow = mouseRow;
                currentCol = mouseCol - 1;
                if (!ifInbounds(field, currentRow, currentCol)) {
                    leftField = true;
                } else {
                    mouseCol = currentCol;
                }
                break;
            case "right":
                currentRow = mouseRow;
                currentCol = mouseCol + 1;
                if (!ifInbounds(field, currentRow, currentCol)) {
                    leftField = true;
                } else {
                    mouseCol = currentCol;
                }
                break;
        }
    }

    private static boolean ifInbounds(char[][] field, int currentRow, int currentCol) {
        return currentRow >= 0 && currentRow < field.length && currentCol >= 0 && currentCol < field.length;
    }

    private static void findMousePosition(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 'M') {
                    mouseRow = i;
                    mouseCol = j;
                    field[i][j] = '-';
                    return;
                }
            }
        }
    }

    private static char[][] createMatrix(Scanner scanner, int size) {
        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
        return matrix;
    }

    private static void printMatrix(char[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }
}
