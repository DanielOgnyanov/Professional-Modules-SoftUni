import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails__07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> user = new LinkedHashMap<>();

        while (true) {
            String name = scanner.nextLine();
            if (name.equals("stop")) {
                break;
            }
            String email = scanner.nextLine();

            if (email.endsWith("bg")) {
                user.put(name, email);
            }
        }

        for (Map.Entry<String, String> print : user.entrySet()) {
            System.out.printf("%s -> %s\n", print.getKey(), print.getValue());
        }
    }
}
