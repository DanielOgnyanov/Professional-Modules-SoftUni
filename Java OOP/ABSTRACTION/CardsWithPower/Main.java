package WorkingWithAbstraction.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        System.out.printf("Card name: %s of %s; Card power: %s", rank, suit,
                Card.valueOf(rank).getValue() + Suit.valueOf(suit).getValue());


    }
}
