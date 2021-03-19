package WorkingWithAbstraction.TrafficLights;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");

        int countOfChanges = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countOfChanges; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.printf("%s ",Lights.valueOf(input[j]).getValue());
                input[j] = Lights.valueOf(input[j]).getValue();
            }
            System.out.println();
        }
    }
}
