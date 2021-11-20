package javaAdvanced.streamFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        List<String> lines = bufferedReader.lines().collect(Collectors.toList());
        PrintWriter printWriter = new PrintWriter("C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output1.txt");
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        List<Character> punctuationMarks = List.of('!', ',', '.', '?');
        int vowelsCount = 0;
        int punctMarksCount = 0;
        int consonansCount = 0;
        for (String line : lines) {
            for (char character : line.toCharArray()) {
                if (character == ' ') {
                } else if (vowels.contains(character)) {
                    vowelsCount++;
                } else if (punctuationMarks.contains(character)) {
                    punctMarksCount++;
                } else {
                    consonansCount++;
                }
            }
        }
        printWriter.println("Vowels: " + vowelsCount);
        printWriter.println("Consonants: " + consonansCount);
        printWriter.println("Punctuation: " + punctMarksCount);
        printWriter.close();

    }
}
