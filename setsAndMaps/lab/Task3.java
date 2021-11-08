package javaAdvanced.setsAndMaps.lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> firstPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> secondPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;
        while (rounds-- > 0) {
            int firstPlayerCard = firstPlayerDeck.stream().findFirst().orElse(0);
            int secondPlayerCard = secondPlayerDeck.stream().findFirst().orElse(0);
            firstPlayerDeck.remove(firstPlayerCard);
            secondPlayerDeck.remove(secondPlayerCard);
            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);


            }
            if (firstPlayerDeck.isEmpty() || secondPlayerDeck.isEmpty()) {
                break;
            }

        }
        if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerDeck.size() > firstPlayerDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}
