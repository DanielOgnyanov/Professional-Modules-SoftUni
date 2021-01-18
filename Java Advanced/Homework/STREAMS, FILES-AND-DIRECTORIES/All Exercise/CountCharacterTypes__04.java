package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CountCharacterTypes__04 {
    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(
                "input.txt"))) {

            PrintWriter print = new PrintWriter(
                    "MyOutput.txt");
            String line = reader.readLine();

            int countVowels = 0;
            int punctuation = 0;
            int consonants = 0;

            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (c != 'a') {
                        if (c == 'e') {
                            countVowels++;
                        } else if (c == 'o') {
                            countVowels++;
                        } else if (c == 'u') {
                            countVowels++;
                        } else if (c == 'i') {
                            countVowels++;
                        } else if (c == '!') {
                            punctuation++;
                        } else if (c == '.') {
                            punctuation++;
                        } else if (c == ',') {
                            punctuation++;
                        } else if (c == '?') {
                            punctuation++;
                        } else if (c != ' ') {
                            consonants++;
                        }
                    } else {
                        countVowels++;
                    }
                }


                line = reader.readLine();
            }
            print.printf("Vowels: %d\n", countVowels);
            print.printf("Consonants: %d\n", consonants);
            print.printf("Punctuation: %d", punctuation);
            print.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}