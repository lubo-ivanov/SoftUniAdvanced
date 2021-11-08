package javaAdvanced.setsAndMaps.lab;

import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> students = new TreeMap<>();
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Double gradeToAdd = Double.parseDouble(input[1]);
            students.putIfAbsent(input[0], new ArrayList<>());
            students.get(input[0]).add(gradeToAdd);
        }

        for (var student: students.entrySet()) {
            System.out.printf("%s -> ", student.getKey());
            double sum = 0;
            for (var grade: student.getValue()) {
                System.out.printf("%.2f ", grade);
                sum += grade;
            }
            System.out.printf("(avg: %.2f)%n", sum / student.getValue().size());
        }
        students.forEach((key, value) -> {
            System.out.printf("%s -> ", key);
            value.forEach(grade -> System.out.printf("%.2f ", grade));
            double sum = value.stream().mapToDouble(Double::doubleValue).sum();
            System.out.printf("(avg: %.2f)%n", sum / value.size());
        });

    }
}
