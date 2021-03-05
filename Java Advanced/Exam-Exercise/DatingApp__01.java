package EXAM.Exam26Oct2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp__01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> male = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::new).collect(Collectors.toCollection(ArrayList::new));

        List<Integer> female = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::new).collect(Collectors.toCollection(ArrayList::new));
        int matches = 0;
        for (int i = male.size() - 1; i >= 0; i--) {
            int currMale = male.get(i);
            for (int j = 0; j < female.size(); j++) {
                int currFemale = female.get(j);

                if (male.get(i) <= 0 || female.get(j) <= 0) {
                    if (male.get(i) <= 0) {
                        male.remove(i);
                    } else {
                        i++;
                    }

                    if (female.get(j) <= 0) {
                        female.remove(j);
                    }
                    break;
                }

                if (male.get(i) % 25 == 0 || female.get(j) % 25 == 0) {
                    if (male.get(i) % 25 == 0) {
                        male.remove(i);
                        i--;
                        male.remove(i);
                    } else {
                        i++;
                    }

                    if (female.get(j) % 25 == 0) {
                        female.remove(j);
                        female.remove(j);
                    }
                    break;
                }

                if (male.get(i).equals(female.get(j))) {
                    male.remove(i);
                    female.remove(j);
                    matches++;
                    break;
                } else {
                    female.remove(j);
                    male.set(i, male.get(i) - 2);
                    i++;
                    break;
                }
            }
        }

        System.out.printf("Matches: %d\n", matches);

        if (!male.isEmpty()) {
            System.out.print("Males left: ");
            for (int i = male.size() - 1; i >= 0; i--) {
                if (i == 0) {
                    System.out.print(male.get(i));
                    System.out.println();
                } else {
                    System.out.print(male.get(i) + ", ");
                }
            }
        } else {
            System.out.println("Males left: none");
        }

        if (!female.isEmpty()) {
            System.out.print("Females left: ");
            for (int i = 0; i < female.size(); i++) {
                if (female.size() - 1 == i) {
                    System.out.print(female.get(i));
                    System.out.println();
                } else {
                    System.out.print(female.get(i) + ", ");
                }
            }
        } else {
            System.out.println("Females left: none");
        }
    }
}
