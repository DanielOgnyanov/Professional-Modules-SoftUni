package IteratorsAndComparators.StrategyPattern;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        TreeSet<People> nameCompare = new TreeSet<>(new CompareName());
        TreeSet<People> ageCompare = new TreeSet<>(new CompareAge());

        for (int i = 0; i < count ; i++) {
            String[] currPerson = scanner.nextLine().split("\\s+");
            People people = new People(currPerson[0], Integer.parseInt(currPerson[1]));
            nameCompare.add(people);
            ageCompare.add(people);
        }

        nameCompare.forEach(System.out::println);
        ageCompare.forEach(System.out::println);

    }
}
