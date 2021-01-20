package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordCount__06 {
    public static void main(String[] args) {
        Map<String,Integer> wordsToCheck = new LinkedHashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(
                "C:\\Users\\Proprietario\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\words.txt"))) {

            String line = reader.readLine();

            while (line != null) {

                for (String c : line.split("\\s+")) {
                    wordsToCheck.put(String.valueOf(c), 0);
                }

                line = reader.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader reader = Files.newBufferedReader(Paths.get(
                "text.txt"))) {
            PrintWriter print = new PrintWriter(
                    "MyOutput.txt");

            String line = reader.readLine();

            while (line != null) {
                for (String c : line.split("\\s+")) {
                    for (Map.Entry<String, Integer> all : wordsToCheck.entrySet()) {
                        if(c.equals(all.getKey())){
                            wordsToCheck.put(c , wordsToCheck.get(c)+1);
                        }
                    }
                }

                line = reader.readLine();
            }


            for (Map.Entry<String, Integer> toPrint : wordsToCheck.entrySet()) {
                print.printf("%s - %d\n", toPrint.getKey(),toPrint.getValue());
            };
            print.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
