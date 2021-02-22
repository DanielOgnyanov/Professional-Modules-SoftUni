package IteratorsAndComparators.ComparingObjects;

import java.util.List;

public class Person<Person extends Comparable<Person>> {
    List<String> person;

    public void add(String person) {
        this.person.add(person);
    }

    public int comparing(List<String> list, String element) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(element) == 0) {
                count++;
            }
        }
        return count;
    }


}
