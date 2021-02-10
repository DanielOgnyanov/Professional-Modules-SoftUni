package Generics.GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        Box<String> currInfo = new Box();
        for (int i = 0; i < num; i++) {
            String command = scanner.nextLine();
            currInfo.add(command);
        }

        System.out.println(currInfo);
    }
}
