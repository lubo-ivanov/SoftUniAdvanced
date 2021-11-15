package javaAdvanced.streamFilesAndDirectories.lab;

import java.io.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Task6 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        PrintWriter printWriter = new PrintWriter("C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt");

        List<String> lines = bufferedReader.lines().sorted().collect(Collectors.toList());

        for (String line : lines) {
            printWriter.println(line);
        }
        printWriter.flush();
        printWriter.close();


    }
}
