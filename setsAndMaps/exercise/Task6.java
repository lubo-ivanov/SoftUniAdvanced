package javaAdvanced.setsAndMaps.exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String material = scanner.nextLine();
        LinkedHashMap<String, Integer> materials = new LinkedHashMap<>();
        while (!material.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            materials.putIfAbsent(material, 0);
            materials.put(material, materials.get(material) + quantity);

            material = scanner.nextLine();
        }
        materials.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
