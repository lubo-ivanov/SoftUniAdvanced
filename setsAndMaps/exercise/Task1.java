package javaAdvanced.setsAndMaps.exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> words = new LinkedHashSet<>();
        while (count-- >0) {
            String input = scanner.nextLine();
            words.add(input);
        }
        for (String word : words) {
            System.out.println(word);
        }
    }
}
