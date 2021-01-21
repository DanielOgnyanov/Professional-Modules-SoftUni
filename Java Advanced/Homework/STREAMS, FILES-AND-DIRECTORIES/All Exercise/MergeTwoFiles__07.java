package StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class MergeTwoFiles__07 {
    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        try (Scanner sc1 = new Scanner((new File("inputOne.txt")));
             Scanner sc2 = new Scanner((new File("inputTwo.txt")))) {

            while (sc1.hasNext()) {
                String s1 = (sc1.hasNext() ? sc1.next() : "");
                output.append(s1);
            }


            while (sc2.hasNext()){
                String s2 = (sc2.hasNext() ? sc2.next() : "");
                output.append(s2);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (PrintWriter pw = new PrintWriter(new File("MyOutput.txt"))) {

            for (char print : output.toString().toCharArray()) {
                pw.println(print);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
