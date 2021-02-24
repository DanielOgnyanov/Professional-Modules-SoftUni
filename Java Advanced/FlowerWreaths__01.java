package EXAM.Exam19August2020;

import java.util.*;
import java.util.stream.Collectors;

public class FlowerWreaths__01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> lilies = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::new).collect(Collectors.toCollection(ArrayList::new));

        List<Integer> roses = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::new).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> storeFlowers = new ArrayList<>();


        int countWreaths = 0;

        for (int i = lilies.size() - 1; i >= 0; i--) {
            int curr = lilies.get(i);

            for (int j = 0; j < roses.size(); j--) {

                int currTwo = roses.get(j);

                if (lilies.get(i) + roses.get(j) == 15) {
                    lilies.remove(i);
                    roses.remove(j);
                    countWreaths++;
                    break;
                }
                else if (lilies.get(i) + roses.get(j) > 15) {

                    int allLilies = lilies.get(i);
                    while (true) {
                        allLilies -= 2;

                        if (allLilies + roses.get(j) == 15) {
                            countWreaths++;
                            lilies.remove(i);
                            roses.remove(j);
                            break;
                        } else if (allLilies + roses.get(j) < 15) {
                            storeFlowers.add(allLilies);
                            storeFlowers.add(roses.get(j));
                            lilies.remove(i);
                            roses.remove(j);
                            break;
                        }
                    }
                } else {
                    storeFlowers.add(lilies.get(i));
                    storeFlowers.add(roses.get(j));
                    lilies.remove(i);
                    roses.remove(j);
                    break;
                }
                break;
            }
        }

        int sum = storeFlowers.stream().mapToInt(Integer::intValue).sum();
        int storedWreaths = sum / 15;

        if (storedWreaths >= 1) {
            countWreaths += storedWreaths;
        }

        if (countWreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", countWreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - countWreaths);
        }

    }
}
