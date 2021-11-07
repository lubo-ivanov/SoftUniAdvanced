package javaAdvanced.stacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plantsCount = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> plants = new ArrayDeque<>();
        for (int i = 0; i < plantsCount; i++) {
            plants.push(scanner.nextInt());
        }

        int daysPassed = -1;
        do {
            plantsCount = plants.size();
            for (int i = 1; i < plantsCount && plants.size() > 1; i++) {
                int firstPlant = plants.poll();
                if (firstPlant <= plants.peek()) {
                    plants.offer(firstPlant);
                }
            }
            plants.offer(plants.poll());
            daysPassed++;
        } while (plants.size() != plantsCount);

        System.out.println(daysPassed);
    }
}
