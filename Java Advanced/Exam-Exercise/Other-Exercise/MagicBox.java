package EXAM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        List<Integer> second = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        List<Integer> claimed = new ArrayList<>();


        while (!first.isEmpty() && !second.isEmpty())   {
            int currFirst = first.get(0);
            int currSecond = second.get(second.size()-1);


            int sum = currFirst + currSecond;

            if(sum % 2 == 0)  {
              claimed.add(sum);
              first.remove(0);
              second.remove(second.size()-1);

            } else {
                int toAdd = second.get(second.size()-1);
                second.remove(second.size()-1);
                first.add(toAdd);
            }



        }

        if(first.isEmpty())  {
            System.out.println("First magic box is empty.");
        }

        if(second.isEmpty())  {
            System.out.println("Second magic box is empty.");
        }


        int finalSum = 0;

        for (int i = 0; i < claimed.size(); i++) {
            finalSum += claimed.get(i);

        }

        if(finalSum >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d",finalSum);
        } else  {
            System.out.printf("Poor prey... Value: %d",finalSum);
        }

    }
}
