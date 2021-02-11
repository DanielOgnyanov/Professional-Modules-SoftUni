package Generics.GenericBoxOfInteger;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        BoxInteger<Integer> current = new BoxInteger<>();
        for (int i = 0; i < num; i++) {
            int numToAdd = Integer.parseInt(scanner.nextLine());
            current.add(numToAdd);
        }

        System.out.println(current);
    }
}
