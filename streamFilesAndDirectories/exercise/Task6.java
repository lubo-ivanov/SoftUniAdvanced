package javaAdvanced.streamFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Task6 {
    public static void main(String[] args) throws IOException {
        String pathWords = "C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String pathText = "C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        BufferedReader bufferedReaderWords = new BufferedReader(new FileReader(pathWords));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathText));
        Map<String, Integer> words = new HashMap<>();
        Arrays.stream(bufferedReaderWords.readLine().split("\\s+")).forEach(e -> words.put(e, 0));
        List<String> lines = bufferedReader.lines().collect(Collectors.toList());
        PrintWriter printWriter = new PrintWriter("C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt");

        for (String line : lines) {
            Arrays.stream(line.split("\\s+")).forEach(e -> {
                if (words.containsKey(e)) {
                    words.put(e, words.get(e) + 1);
                }
            });
        }
        words.entrySet().stream().sorted(Comparator.comparing(e-> -e.getValue())).forEach(e-> {
            printWriter.println(e.getKey() + " - " + e.getValue());
        });

        printWriter.close();

    }
}
