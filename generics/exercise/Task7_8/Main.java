package javaAdvanced.generics.exercise.Task7_8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> list = new CustomList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Add":
                    list.add(command[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(command[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(command[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(command[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    if (!list.isEmpty()) {
                        list.print();
                    }
                    break;
                case "Sort":
                    Sorter.sort(list);
            }
            input = scanner.nextLine();
        }
    }
}
