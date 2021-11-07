package javaAdvanced.setsAndMaps.exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countFirst = scanner.nextInt();
        int countSecond = scanner.nextInt();
        scanner.nextLine();
        LinkedHashSet<String> firstSet = new LinkedHashSet<>();
        LinkedHashSet<String> secondSet = new LinkedHashSet<>();
        while (countFirst-- > 0) {
            firstSet.add(scanner.nextLine());
        }
        while (countSecond-- > 0) {
            secondSet.add(scanner.nextLine());
        }
        firstSet.retainAll(secondSet);
        System.out.println(String.join(" ", firstSet));
    }
}
