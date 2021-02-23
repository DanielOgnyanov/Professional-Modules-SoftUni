package IteratorsAndComparators.StrategyPattern;

import java.util.Comparator;

public class CompareName implements Comparator<People> {


    @Override
    public int compare(People x, People y) {
        int result = x.getName().length() - y.getName().length();

        if (result == 0) {
            result = x.getName().toLowerCase().charAt(0) - y.getName().toLowerCase().charAt(0);
        }
        return result;
    }
}
