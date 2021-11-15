package javaAdvanced.streamFilesAndDirectories.lab;

import java.io.*;

import java.util.List;
import java.util.stream.Collectors;


public class Task5 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        PrintWriter printWriter = new PrintWriter("C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt");

        List<String> lines = bufferedReader.lines().collect(Collectors.toList());
        for (int i = 1; i <= lines.size(); i++) {
            if (i % 3 == 0) {
                printWriter.println(lines.get(i-1));
            }
        }
        printWriter.flush();
        printWriter.close();


    }
}
