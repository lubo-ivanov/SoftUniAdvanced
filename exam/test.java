package javaAdvanced.exam;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //number of ingredients in a single bucket
        int[] numberOfIngredients = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        // freshness level of the ingredients
        int[] freshnessLevel = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> bucketAsQueue = new ArrayDeque<>(); //number of ingredients
        Deque<Integer> freshnessAsStack = new ArrayDeque<>(); //freshness of ingredients

        //fill the STACK & QUEUE
        Arrays.stream(numberOfIngredients).forEach(bucketAsQueue::offer);
        Arrays.stream(freshnessLevel).forEach(freshnessAsStack::push);

        int totalFreshnessLevel = 0;
        Map<String, Integer> tableOfCocktail = new TreeMap<>();
        tableOfCocktail.put("Pear Sour", 0);
        tableOfCocktail.put("The Harvest", 0);
        tableOfCocktail.put("Apple Hinny", 0);
        tableOfCocktail.put("High Fashion", 0);

        while (!bucketAsQueue.isEmpty() && !freshnessAsStack.isEmpty()) {
            int numFromQueue = bucketAsQueue.poll();
            if (numFromQueue == 0) {
                continue;
            }
            int numFromStack = freshnessAsStack.pop();
            totalFreshnessLevel = numFromQueue * numFromStack;
            switch (totalFreshnessLevel) {
                case 150:
                    tableOfCocktail.put("Pear Sour", tableOfCocktail.get("Pear Sour") + 1);
                    break;
                case 250:
                    tableOfCocktail.put("The Harvest", tableOfCocktail.get("The Harvest") + 1);
                    break;
                case 300:
                    tableOfCocktail.put("Apple Hinny", tableOfCocktail.get("Apple Hinny") + 1);
                    break;
                case 400:
                    tableOfCocktail.put("High Fashion", tableOfCocktail.get("High Fashion") + 1);
                    break;
                default:
                    bucketAsQueue.offer(numFromQueue + 5);
                    break;

            }
        }
        if (isFilled(tableOfCocktail)) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!bucketAsQueue.isEmpty()) {
            int sum = 0;
            for (Integer ingredient : bucketAsQueue) {
                sum += ingredient;
            }
            System.out.printf("Ingredients left: %d%n", sum);
        }
        tableOfCocktail.entrySet().stream().filter(e -> e.getValue() > 0)
                .forEach(е -> System.out.printf(" # %s --> %d%n", е.getKey(), е.getValue()));

    }

    private static boolean isFilled(Map<String, Integer> tableOfCocktail) {
        return tableOfCocktail.get("Pear Sour") > 0 &&
                tableOfCocktail.get("The Harvest") > 0 && tableOfCocktail.get("Apple Hinny") > 0
                && tableOfCocktail.get("High Fashion") > 0;
    }
}