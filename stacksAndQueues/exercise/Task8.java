package javaAdvanced.stacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> text = new ArrayDeque<>();
        ArrayDeque<String[]> undoMap = new ArrayDeque<>();
//        ArrayDeque<Character> backUp = new ArrayDeque<>();
//        ArrayDeque<Integer> undoAddCount = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]) {
                case "1":
                    for (int j = 0; j < command[1].length(); j++) {
                        text.offer(command[1].charAt(j));
                    }
                    undoMap.offer(new String[]{command[0], command[1]});
                    break;
                case "2":
                    int charsToDelete = Integer.parseInt(command[1]);
                    StringBuilder removedString = new StringBuilder();
                    for (int j = 0; j < charsToDelete; j++) {
                        removedString.append(text.removeLast());
                    }
                    undoMap.offer(new String[]{command[0], removedString.reverse().toString()});
                    break;
                case "3":
                    int indexToPrint = Integer.parseInt(command[1]);
                    for (int j = 0; j < text.size(); j++) {
                        text.offer(text.poll());
                        if (indexToPrint-1 == j) {
                            System.out.println(text.peekLast());
                        }
                    }

                    break;
                case "4":
                    String[] undoCommand = undoMap.removeLast();
                    if (undoCommand[0].equals("1")) {
                        for (int j = 0; j < undoCommand[1].length(); j++) {
                            text.removeLast();
                        }
                    } else {
                        for (int j = 0; j < undoCommand[1].length(); j++) {
                            text.offer(undoCommand[1].charAt(j));
                        }
                    }
                    break;

            }
        }

    }
}
