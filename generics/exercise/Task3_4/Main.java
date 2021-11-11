package javaAdvanced.generics.exercise.Task3_4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Box items = new Box<>();
        for (int i = 0; i < n; i++) {
            items.add(Integer.parseInt(scanner.nextLine()));
        }
        int[] indexes=Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        items.swap(indexes[0], indexes[1]);

        System.out.println(items);

    }
}
