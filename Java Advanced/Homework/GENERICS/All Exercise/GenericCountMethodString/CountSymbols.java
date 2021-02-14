package Generics.GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class CountSymbols<T extends Comparable<T>> {

    List<T> genericList;

    public CountSymbols() {
        this.genericList = new ArrayList<>();
    }

    public void add(T element) {
        this.genericList.add(element);
    }



    public int greater (List<T> list, T element){
         int count = (int) list.stream().filter(e -> e.compareTo(element) > 0).count();
         return  count;
    }
}
