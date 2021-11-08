package javaAdvanced.setsAndMaps.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, Integer>> userInfo = new TreeMap<>();
        while (count-- >0) {
        String [] input = scanner.nextLine().split("\\s+");
        String ip = input[0];
        String userName = input[1];
        int time = Integer.parseInt(input[2]);
            userInfo.putIfAbsent(userName, new TreeMap<>());
            userInfo.get(userName).putIfAbsent(ip, 0);
            userInfo.get(userName).put(ip, userInfo.get(userName).get(ip) + time);
        }
        userInfo.forEach((key, value) -> {
            System.out.print(key+ ": ");
            System.out.print(value.values().stream().mapToInt(Integer::intValue).sum() + " ");
            System.out.println(value.keySet());
        });
    }
}
