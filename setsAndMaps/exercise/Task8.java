package javaAdvanced.setsAndMaps.exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> playersCards = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {

            String[] tokens = input.split(": ");
            playersCards.putIfAbsent(tokens[0], new HashSet<>());
            playersCards.get(tokens[0]).addAll(Arrays.asList(tokens[1].split(", ")));
            input = scanner.nextLine();
        }
        for (var playerName : playersCards.entrySet()) {
            int totalCardValue = 0;
            for (String card : playerName.getValue()) {
                int type = getType(card);
                int power = getPower(card);
                totalCardValue += type * power;
            }
            System.out.printf("%s: %d%n", playerName.getKey(), totalCardValue);
        }
    }

    public static int getType(String card) {
        int type = 0;
        switch (card.split("")[card.length() - 1]) {
            case "S":
                type = 4;
                break;
            case "H":
                type = 3;
                break;
            case "D":
                type = 2;
                break;
            case "C":
                type = 1;
                break;
        }
        return type;
    }

    public static int getPower(String card) {
        int power = 0;
        if (card.length() == 3) {
            card = card.substring(0, 2);
        } else {
            card = card.split("")[0];
        }
        switch (card) {
            case "J":
                power = 11;
                break;
            case "Q":
                power = 12;
                break;
            case "K":
                power = 13;
                break;
            case "A":
                power = 14;
                break;
            default:
                power = Integer.parseInt(card);
                break;
        }
        return power;
    }
}