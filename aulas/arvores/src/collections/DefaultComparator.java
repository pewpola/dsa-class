package collections;

import java.util.Comparator;

public class DefaultComparator<T> implements Comparator<T> {

    @Override
    @SuppressWarnings("unchecked")
    public int compare(T o1, T o2) {
        return ((Comparable<T>) o1).compareTo(o2);
    }
}
