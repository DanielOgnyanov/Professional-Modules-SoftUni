package IteratorsAndComparators.Froggy;

import java.util.*;
import java.util.stream.Collectors;

public class Lake {
    public Lake(List<Integer> allNumbers) {
        this.allNumbers = allNumbers;
    }

    List<Integer> allNumbers;
    List<Integer> even = new ArrayList<>();
    List<Integer> odd = new ArrayList<>();


    public void fillTheList() {
        for (int i = 0; i < allNumbers.size(); i++) {
            if (i % 2 == 0) {
                even.add(allNumbers.get(i));
            } else {
                odd.add(allNumbers.get(i));
            }
        }
    }

    public void toPrint() {
        for (int i = 0; i < even.size(); i++) {
            if (odd.isEmpty()) {
                System.out.print(even.get(i));
                return;
            }
            System.out.print(even.get(i) + ", ");
        }

        for (int i = 0; i < odd.size(); i++) {

            if (odd.size() - 1 == i) {
                System.out.print(odd.get(i));
            } else {
                System.out.print(odd.get(i) + ", ");
            }
        }


    }


}
