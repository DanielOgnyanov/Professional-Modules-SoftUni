package Generics.GenericSwapMethodString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Swap<T> {
    List<T> elements;

    public Swap() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public void setElements(List<T> e, int firstIndex, int secondIndex) {
        Collections.swap(e, firstIndex, secondIndex);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T element : elements) {
            sb.append(String.format("%s: %s", element.getClass().getName(), element));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }


}
