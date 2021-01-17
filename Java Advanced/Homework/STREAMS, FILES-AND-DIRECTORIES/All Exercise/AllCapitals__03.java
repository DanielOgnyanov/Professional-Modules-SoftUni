package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllCapitals__03 {
    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(
                "input.txt"))) {

            PrintWriter print = new PrintWriter(
                    "MyOutput.txt");

            String line = reader.readLine();

            while (line != null) {
                String upper = line.toUpperCase();

                print.println(upper);
                line = reader.readLine();
            }
            print.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

