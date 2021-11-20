package javaAdvanced.streamFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Task7 {
    public static void main(String[] args) throws IOException {
        Path pathFirst = Path.of("C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        String pathSecond = "C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        BufferedReader bufferedReaderSecond = new BufferedReader(new FileReader(pathSecond));
        List<String> linesSecond = bufferedReaderSecond.lines().collect(Collectors.toList());

        PrintWriter printWriter = new PrintWriter("C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output_mergedFiles.txt");

        List<String> linesFirst = Files.readAllLines(pathFirst);
        for (String line : linesFirst) {
            printWriter.println(line);
        }
        for (String line : linesSecond) {
            printWriter.println(line);
        }

        printWriter.close();

    }
}
