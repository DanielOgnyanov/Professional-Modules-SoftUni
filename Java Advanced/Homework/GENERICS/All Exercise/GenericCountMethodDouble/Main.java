package Generics.GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        DoubleSymbols<Double> doubleSymbols = new DoubleSymbols<>();
        List<Double> item = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Double currNum = Double.parseDouble(scanner.nextLine());
            item.add(currNum);
        }
        Double element = Double.parseDouble(scanner.nextLine());
        int toPrint = doubleSymbols.greater(item, element);



        System.out.println(toPrint);
    }
}
