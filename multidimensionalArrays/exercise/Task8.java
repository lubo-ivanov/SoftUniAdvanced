package javaAdvanced.multidimensionalArrays.exercise;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double heiganHP = 3000000.0;
        int playerHP = 18500;

        double damageToHeigan = Double.parseDouble(scanner.nextLine());
        int roomSize = 15;
        int damageArea = 3;
        int[] playerPosition = new int[]{7, 7};
        int[] roomCentre = playerPosition;
        boolean hitByCLoud = false;
        boolean playerDead = false;
        String spellName = "";
        while (heiganHP > 0) {
            heiganHP -= damageToHeigan;
            if (hitByCLoud) {
                playerHP -= 3500;
                hitByCLoud = false;
                if (playerHP <= 0) {
                    playerDead = true;
                    break;
                }
            }
            if (heiganHP <= 0) {
                break;
            }
            String[] spell = scanner.nextLine().split("\\s+");
            spellName = spell[0];
            int[] spellCentre = new int[]{Integer.parseInt(spell[1]), Integer.parseInt(spell[2])};

            if (isInBounds(playerPosition, damageArea, spellCentre)) {
                boolean playerMoved = false;
                int[] moveUp = new int[]{playerPosition[0] - 1, playerPosition[1]};
                int[] moveRight = new int[]{playerPosition[0], playerPosition[1] + 1};
                int[] moveDown = new int[]{playerPosition[0] + 1, playerPosition[1]};
                int[] moveLeft = new int[]{playerPosition[0], playerPosition[1] - 1};

                if (isInBounds(moveUp, roomSize, roomCentre) && !isInBounds(moveUp, damageArea, spellCentre)) {
                    playerPosition = moveUp;
                    playerMoved = true;
                }
                if (!playerMoved && isInBounds(moveRight, roomSize, roomCentre) && !isInBounds(moveRight, damageArea, spellCentre)) {
                    playerPosition = moveRight;
                    playerMoved = true;
                }
                if (!playerMoved && isInBounds(moveDown, roomSize, roomCentre) && !isInBounds(moveDown, damageArea, spellCentre)) {
                    playerPosition = moveDown;
                    playerMoved = true;
                }
                if (!playerMoved && isInBounds(moveLeft, roomSize, roomCentre) && !isInBounds(moveLeft, damageArea, spellCentre)) {
                    playerPosition = moveLeft;
                    playerMoved = true;
                }
                if (!playerMoved) {
                    switch (spellName) {
                        case "Cloud":
                            hitByCLoud = true;
                            playerHP -= 3500;
                            break;
                        case "Eruption":
                            playerHP -= 6000;
                            break;
                    }
                }
            }

            if (playerHP <= 0) {
                playerDead = true;
                break;
            }
        }

        if (spellName.equals("Cloud")) {
            spellName = "Plague Cloud";
        }
        if (heiganHP <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHP);
        }
        if (playerDead) {
            System.out.printf("Player: Killed by %s%n", spellName);
        } else {
            System.out.println("Player: " + playerHP);
        }
        System.out.printf("Final position: %d, %d", playerPosition[0], playerPosition[1]);


    }

    private static boolean isInBounds(int[] playerPosition, int size, int[] centre) {
        return playerPosition[0] >= centre[0] - size / 2 && playerPosition[0] <= centre[0] + size / 2
                && playerPosition[1] >= centre[1] - size / 2 && playerPosition[1] <= centre[1] + size / 2;
    }
}
