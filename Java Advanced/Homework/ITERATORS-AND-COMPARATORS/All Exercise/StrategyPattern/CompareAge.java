package IteratorsAndComparators.StrategyPattern;

import java.util.Comparator;

public class CompareAge implements Comparator<People> {

    @Override
    public int compare(People x, People y) {
        return x.getAge() - y.getAge();

    }
}
