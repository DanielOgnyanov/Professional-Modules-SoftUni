import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements__02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] setLen = scanner.nextLine().split("\\s+");
        int firstSetLen = Integer.parseInt(setLen[0]);
        int secondSetLen = Integer.parseInt(setLen[1]);
        int sumLen = firstSetLen + secondSetLen;
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < 1; i++) {

            for (int j = 0; j < firstSetLen; j++) {
                int currNum = Integer.parseInt(scanner.nextLine());
                firstSet.add(currNum);
            }


            for (int k = 0; k < secondSetLen; k++) {
                int currNum = Integer.parseInt(scanner.nextLine());
                secondSet.add(currNum);
            }


        }
        firstSet.retainAll(secondSet);

        for (Integer print : firstSet) {
            System.out.print(print + " ");

        }


    }
}
