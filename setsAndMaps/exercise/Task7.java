package javaAdvanced.setsAndMaps.exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> contactBook = new LinkedHashMap<>();

        String user = scanner.nextLine();
        while (!user.equals("stop")) {
            String email = scanner.nextLine();
            String[] tokenizedEmail = email.split("\\.");
            if (!tokenizedEmail[tokenizedEmail.length-1].equals("us") &&
                    !tokenizedEmail[tokenizedEmail.length-1].equals("uk") &&
                    !tokenizedEmail[tokenizedEmail.length-1].equals("com")) {
                contactBook.put(user, email);
            }
            user = scanner.nextLine();
        }
        contactBook.forEach((key, value) -> System.out.println(key + " -> " + value));


    }
}
