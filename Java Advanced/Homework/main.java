package DefiningClasses.OpinionPoll;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPerson = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> people = new TreeMap<>();
        for (int i = 0; i < countPerson; i++) {
            String command = scanner.nextLine();
            String[] operations = command.split("\\s+");
            String name = operations[0];
            int age = Integer.parseInt(operations[1]);
            Person person = new Person(name, age);


            if (age > 30) {
                people.put(name, age);
            } else {
                continue;
            }


        }

        for (Map.Entry<String, Integer> print : people.entrySet()) {
            System.out.printf("%s - %d\n", print.getKey(), print.getValue());
        }


    }
}
