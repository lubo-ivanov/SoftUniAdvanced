package javaAdvanced.streamFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);

        int oneByte = inputStream.read();
        PrintStream printStream = new PrintStream("C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt");
        while (oneByte >=0) {
            char symbol = (char) oneByte;
            if (oneByte == ' ' || oneByte == '\n') {
                printStream.print(symbol);
            } else {
                printStream.print(oneByte);
            }
                oneByte = inputStream.read();
        }
    }
}
