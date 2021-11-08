package javaAdvanced.setsAndMaps.lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> stores = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);
            stores.putIfAbsent(shop, new LinkedHashMap<>());
            stores.get(shop).put(product, price);
            input = scanner.nextLine();
        }
        for (var store : stores.entrySet()) {
            System.out.println(store.getKey() + "->");
            for (var product : store.getValue().entrySet()) {
                System.out.printf("javaOOP.encapsulation.exercise.shoppingSpree.Product: %s, Price: %.1f%n", product.getKey(), product.getValue());
            }
        }


    }
}
