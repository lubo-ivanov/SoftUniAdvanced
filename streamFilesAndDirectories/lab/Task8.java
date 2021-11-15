package javaAdvanced.streamFilesAndDirectories.lab;

import java.io.File;
import java.util.ArrayDeque;

public class Task8 {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\Lubo\\IdeaProjects\\javaAdvanced\\src\\javaAdvanced\\streamFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        ArrayDeque<File> allFolders = new ArrayDeque<>();


        allFolders.offer(file);
        int i = 0;
//        while (!allFolders.isEmpty()) {
//            System.out.println(allFolders.peek().getName());
//            i++;
//            File[] folders = allFolders.pop().listFiles();
//            for (File folder : folders) {
//                if (folder.isDirectory()) {
//                    allFolders.push(folder);
//                }
//            }
//        }
//        System.out.println(i + " folders");
        while (!allFolders.isEmpty()) {
            System.out.println(allFolders.peek().getName());
            i++;
            File[] folders = allFolders.poll().listFiles();
            for (File folder: folders) {
                if (folder.isDirectory()) {
                    allFolders.offer(folder);
                }
            }
        }
        System.out.println(i + " folders");

    }
}
