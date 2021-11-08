package javaAdvanced.setsAndMaps.lab;

import java.util.Scanner;
import java.util.TreeSet;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeSet<String> partyList = new TreeSet<>();
        while (!input.equals("PARTY")) {
            partyList.add(input);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("END")) {
            partyList.remove(input);

            input = scanner.nextLine();
        }
        System.out.println(partyList.size());
        partyList.forEach(System.out::println);

    }
}
