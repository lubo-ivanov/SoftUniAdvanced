package javaAdvanced.setsAndMaps.lab;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();
        while (rows-- > 0) {
            String studentName = scanner.nextLine();
            List<Double> scores = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());
            students.putIfAbsent(studentName, new ArrayList<>());
            students.get(studentName).addAll(scores);
        }

        students.forEach((name, grades) -> {
            Double sum = 0d;
            for (Double grade : grades) {
                sum += grade;
            }
            Double avg = sum / grades.size();


            System.out.printf("%s is graduated with %f%n", name, avg);
        });

    }
}
