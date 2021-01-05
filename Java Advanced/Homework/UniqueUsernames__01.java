import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames__01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCount = Integer.parseInt(scanner.nextLine());
        Set<String> user = new LinkedHashSet<>();

        for (int i = 0; i < numCount ; i++) {
            String currInput = scanner.next();
            user.add(currInput);
        }

        for (String currUser : user) {
            System.out.println(currUser);
        }

    }
}
