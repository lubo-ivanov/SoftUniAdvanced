package javaAdvanced.setsAndMaps.lab;

import java.util.*;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> atlas = new LinkedHashMap<>();
        while (count-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];
            atlas.putIfAbsent(continent, new LinkedHashMap<>());
            atlas.get(continent).putIfAbsent(country, new ArrayList<>());
            atlas.get(continent).get(country).add(city);
        }
        for (var continent : atlas.entrySet()) {
            System.out.println(continent.getKey() + ":");
            for (var country : continent.getValue().entrySet()) {
                System.out.print(" "+ country.getKey() + " -> ");
                System.out.println(String.join(", ", country.getValue()));
            }
        }

    }
}
