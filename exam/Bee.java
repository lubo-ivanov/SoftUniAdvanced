package javaAdvanced.exam;


import java.util.Scanner;

public class Bee {
    static int beeRow;
    static int beeCol;
    static boolean leftField = false;
    static int pollinatedFlowers = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = createMatrix(scanner, size);
        findBeePosition(field);

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            moveBee(field, command);

            if (leftField) {
                System.out.println("The bee got lost!");
                break;
            }
            checkPosition(field, command);
            command = scanner.nextLine();
        }


        if (!leftField) {
            field[beeRow][beeCol] = 'B';
        }
        if (pollinatedFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        }

        printMatrix(field);
    }

    private static void checkPosition(char[][] field, String command) {
        if (field[beeRow][beeCol] == 'f') {
            field[beeRow][beeCol] = '.';
            pollinatedFlowers++;
        } else if (field[beeRow][beeCol] == 'O') {
            field[beeRow][beeCol] = '.';
            moveBee(field, command);
            checkPosition(field, command);
        }

    }

    private static void moveBee(char[][] field, String command) {
        int currentRow;
        int currentCol;
        switch (command) {
            case "up":
                currentRow = beeRow - 1;
                currentCol = beeCol;
                if (!ifInbounds(field, currentRow, currentCol)) {
                    leftField = true;
                } else {
                    beeRow = currentRow;
                }
                break;
            case "down":
                currentRow = beeRow + 1;
                currentCol = beeCol;
                if (!ifInbounds(field, currentRow, currentCol)) {
                    leftField = true;
                } else {
                    beeRow = currentRow;
                }
                break;
            case "left":
                currentRow = beeRow;
                currentCol = beeCol - 1;
                if (!ifInbounds(field, currentRow, currentCol)) {
                    leftField = true;
                } else {
                    beeCol = currentCol;
                }
                break;
            case "right":
                currentRow = beeRow;
                currentCol = beeCol + 1;
                if (!ifInbounds(field, currentRow, currentCol)) {
                    leftField = true;
                } else {
                    beeCol = currentCol;
                }
                break;
        }
    }

    private static boolean ifInbounds(char[][] field, int currentRow, int currentCol) {
        return currentRow >= 0 && currentRow < field.length && currentCol >= 0 && currentCol < field.length;
    }

    private static void findBeePosition(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 'B') {
                    beeRow = i;
                    beeCol = j;
                    field[i][j] = '.';
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
