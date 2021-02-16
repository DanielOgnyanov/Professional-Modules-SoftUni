package Generics.CustomList;

import java.lang.reflect.Array;
import java.util.*;


public class CustomList<T extends Comparable<T>> {
    List<T> list;

    public CustomList(){
        this.list = new ArrayList<>();

    }

    public void add(T element){
        this.list.add(element);
    }

    public void remove(int index){
       this.list.remove(index);
    }


    public boolean contains(T elementToCheck){
          if(this.list.contains(elementToCheck)){
              System.out.println("true");
              return true;
          }else {
              System.out.println("false");
          }
          return false;
    }

    public void swap(int indexOne, int indexTwo){
        Collections.swap(this.list,indexOne,indexTwo);
    }

    public int greater (List<T> list, T element){
        int count = (int) list.stream().filter(e -> e.compareTo(element) > 0).count();
        System.out.println(count);
        return  count;
    }

    public  <T extends Comparable<T>> T maxValue(List<T> array){
        T max = array.get(0);
        for(T data: array){
            if(data.compareTo(max)>0)
                max =data;
        }
        System.out.println(max);
        return max;
    }


    public  <T extends Comparable<T>> T minValue(List<T> array){
        T min = array.get(0);
        for(T data: array){
            if(min.compareTo(data)>0) min =data;

        }
        System.out.println(min);
        return min;
    }

    public void print(){
        for (T t : list) {
            System.out.println(t);
        }
    }
}
