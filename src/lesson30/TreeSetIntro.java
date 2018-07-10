package lesson30;

import lesson29.File;

import java.util.TreeSet;

public class TreeSetIntro {
    public static void main(String[] args) {
        TreeSet<File> files = new TreeSet<>();

        File file1 = new File("pic.txt", 987);
        File file2 = new File("home.txt", 1);
        File file3 = new File("text.txt", 340);

        files.add(file1);
        files.add(file2);
        files.add(file3);

        System.out.println(files);
    }
}
