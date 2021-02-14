package Generics.GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        CountSymbols<String> currentSymbols = new CountSymbols<>();
        List<String> item = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String currString = scanner.nextLine();
            item.add(currString);
        }
        String element = scanner.nextLine();
        int toPrint = currentSymbols.greater(item, element);



        System.out.println(toPrint);


    }
}
