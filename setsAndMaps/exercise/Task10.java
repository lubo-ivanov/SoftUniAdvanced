package javaAdvanced.setsAndMaps.exercise;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();
        while (!input.equals("report")) {
            String city = input.split("\\|")[0];
            String country = input.split("\\|")[1];
            long population = Long.parseLong(input.split("\\|")[2]);
            countries.putIfAbsent(country, new LinkedHashMap<>(Map.of(city, population)));
            countries.get(country).put(city, population);

            input = scanner.nextLine();
        }
        countries.entrySet().stream().sorted(Comparator.comparing((e -> -e.getValue().values().stream().mapToLong(Long::longValue).sum())))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + " (total population: " + entry.getValue().values().stream().mapToLong(Long::longValue).sum() + ")");
                    entry.getValue().entrySet().stream().sorted(Comparator.comparing(e -> -e.getValue()))
                            .forEach(city -> System.out.println("=>" + city.getKey() + ": " + city.getValue()));
                });
    }
}