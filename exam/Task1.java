package javaAdvanced.exam;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> ingredientsQueue = new ArrayDeque<>();
        Deque<Integer> freshnessStack = new ArrayDeque<>();
        Map<Integer, Integer> cocktailsToMake = new HashMap<>(Map.of(300, 0, 400, 0, 150, 0, 250, 0));
        int[] firstLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (Integer integer : firstLine) {
            ingredientsQueue.offer(integer);
        }
        for (Integer integer : secondLine) {
            freshnessStack.push(integer);
        }


        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {
            int ingredients = ingredientsQueue.poll();
            if (ingredients == 0) {
                continue;
            }
            int freshness = freshnessStack.pop();
            int totalFreshness = ingredients * freshness;

            if (cocktailsToMake.containsKey(totalFreshness)) {
                cocktailsToMake.replace(totalFreshness, cocktailsToMake.get(totalFreshness) + 1);
            } else {
                ingredientsQueue.offer(ingredients + 5);
            }
        }

        int cocktailsMade = (int) cocktailsToMake.entrySet().stream().filter(e -> e.getValue() == 0).count();
        if (cocktailsMade > 0) {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        } else {
            System.out.println("It's party time! The cocktails are ready!");
        }
        if (!ingredientsQueue.isEmpty()) {
            System.out.println("Ingredients left: " + ingredientsQueue.stream().mapToInt(e -> e).sum());
        }
        if (cocktailsToMake.get(300) > 0) {
            System.out.println(" # Apple Hinny --> " + cocktailsToMake.get(300));
        }
        if (cocktailsToMake.get(400) > 0) {
            System.out.println(" # High Fashion --> " + cocktailsToMake.get(400));
        }
        if (cocktailsToMake.get(150) > 0) {
            System.out.println(" # Pear Sour --> " + cocktailsToMake.get(150));
        }
        if (cocktailsToMake.get(250) > 0) {
            System.out.println(" # The Harvest --> " + cocktailsToMake.get(250));
        }

    }
}
