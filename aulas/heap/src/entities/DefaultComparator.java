package entities;

import java.util.Comparator;

public class DefaultComparator<E> implements Comparator<E>{

    @Override
    @SuppressWarnings("unchecked")
    public int compare(E o1, E o2) {
        return ((Comparable<E>) o1).compareTo(o2);
    }
}
