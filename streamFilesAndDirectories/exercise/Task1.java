package javaAdvanced.streamFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
               BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        List<String> lines = bufferedReader.lines().collect(Collectors.toList());

        for (String line: lines) {
            int sum = 0;
            for (char character: line.toCharArray()) {
                sum += character;
            }
            System.out.println(sum);
        }
    }
}
