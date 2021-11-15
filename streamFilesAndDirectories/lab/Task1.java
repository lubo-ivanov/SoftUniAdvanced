package javaAdvanced.streamFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


public class Task1 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathToWrite = "C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        FileInputStream filestream = new FileInputStream(path);
        PrintStream printStream = new PrintStream(pathToWrite);
        Scanner scanner = new Scanner(filestream);

            int oneByte = filestream.read();
            while (oneByte >= 0) {
                char charToRead = (char) oneByte;
                if (charToRead == ',' ||
                charToRead == '.' ||
                charToRead == '!' ||
                        charToRead == '?') {
                    oneByte = filestream.read();
                    continue;
                } else {
                    printStream.write(charToRead);
                }
                oneByte = filestream.read();
            }
            printStream.flush();
            printStream.close();

    }
}
