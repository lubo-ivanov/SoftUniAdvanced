package javaAdvanced.streamFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        List<String> lines = bufferedReader.lines().collect(Collectors.toList());
        PrintWriter printWriter = new PrintWriter("C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");

        for (String line : lines) {
            printWriter.println(line.toUpperCase());
        }
        printWriter.close();

    }
}
