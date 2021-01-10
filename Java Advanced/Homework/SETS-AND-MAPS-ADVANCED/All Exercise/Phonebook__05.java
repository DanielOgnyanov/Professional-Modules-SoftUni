import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Phonebook__05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, String> user = new TreeMap<>();

        while (!command.equals("search")) {
            String[] currUser = command.split("-");
            String name = currUser[0];
            String phone = currUser[1];
            user.put(name, phone);
            command = scanner.nextLine();
        }

        command = scanner.nextLine();

        while (!command.equals("stop")) {

            if (user.containsKey(command)) {
                for (Map.Entry<String, String> print : user.entrySet()) {
                    if (print.getKey().equals(command)) {
                        System.out.printf("%s -> %s\n", print.getKey(), print.getValue());
                    }
                }
            } else {
                System.out.printf("Contact %s does not exist.\n", command);

            }
            command = scanner.nextLine();
        }
    }
}
