package javaAdvanced.iteratorsAndComparators.exercise.Task4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Lake lake = new Lake(Arrays.stream(reader.readLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList()));
        String input = reader.readLine();
        List<String> output = new ArrayList<>();
        for (Integer stone : lake) {
            output.add(String.valueOf(stone));
        }
        System.out.println(String.join(", ", output));

    }


}
