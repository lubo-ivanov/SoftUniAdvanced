package javaAdvanced.setsAndMaps.exercise;

import java.util.*;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> log = new TreeMap<>();
        while (!input.equals("end")) {
            String userIP = input.split("\\s+")[0].substring(3);
            String username = input.split("\\s+")[2].substring(5);
            log.putIfAbsent(username, new LinkedHashMap<>());
            log.get(username).putIfAbsent(userIP, 0);
            log.get(username).put(userIP, log.get(username).get(userIP) + 1);

            input = scanner.nextLine();
        }
        for (var user : log.entrySet()) {
            System.out.println(user.getKey() + ": ");
            List<String> ipList = new ArrayList<>();
            for (var ip : user.getValue().entrySet()) {
                ipList.add(String.format("%s => %d", ip.getKey(), ip.getValue()));
            }
            System.out.print(String.join(", ", ipList));
            System.out.println(".");
        }
    }
}
