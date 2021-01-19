package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers__05 {
    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(
                "inputLineNumbers.txt"))) {

            PrintWriter print = new PrintWriter(
                    "MyOutput.txt");

            String line = reader.readLine();
            int countLine = 1;
            while (line != null) {
                String currLine = line;

                print.printf("%d. %s\n",countLine,currLine);
                countLine++;
                line = reader.readLine();
            }
            print.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
