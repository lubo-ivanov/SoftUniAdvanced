package javaAdvanced.streamFilesAndDirectories.exercise;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Task8 {
    public static void main(String[] args) throws IOException {
        File folder = new File("C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        int size = Arrays.stream(folder.listFiles()).mapToInt(e -> (int) e.length()).sum();
        System.out.println("Folder size: " + size);
    }
}
