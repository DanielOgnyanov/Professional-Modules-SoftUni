package Generics.GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;

public class DoubleSymbols<T extends Comparable<T>> {

    public DoubleSymbols() {
        this.genericList = new ArrayList<>();
    }

    List<T> genericList;



    public void add(T element) {
        this.genericList.add(element);
    }



    public int greater (List<T> list, T element){
        int count = (int) list.stream().filter(e -> e.compareTo(element) > 0).count();
        return  count;
    }
}
