package javaAdvanced.streamFilesAndDirectories.lab;

import java.io.File;
import java.io.IOException;

public class Task7 {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File[] files = file.listFiles();

        for (File subfile: files) {
            if (!subfile.isDirectory()) {
                System.out.printf("%s: [%d]\n", subfile.getName(), subfile.length());
            }
        }
    }
}
