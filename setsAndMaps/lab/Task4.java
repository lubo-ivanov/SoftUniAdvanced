package javaAdvanced.setsAndMaps.lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double, Integer> mapOfNumbers = new LinkedHashMap<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).forEach(element ->{
            mapOfNumbers.putIfAbsent(element, 0);
            mapOfNumbers.put(element, mapOfNumbers.get(element) + 1);
        });
        mapOfNumbers.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }

}
