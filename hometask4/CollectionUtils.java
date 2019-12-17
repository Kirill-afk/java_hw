package hw_4;

import java.util.*;

public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List newArrayList() {
        return new ArrayList<T>();
    }

    public static<T> int indexOf(List<? extends T> source, Object o) {
        return source.indexOf(o);
    }

    public static<T> List limit(List<? extends T> source, int size) {
        List<T> newAL = new ArrayList<>(source);
        return newAL.subList(0, size);
    }

    public static<T> void add(List<? super T> source, Object o) {
        source.add((T) o);
    }

    public static<T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        for(T t: c2){
            removeFrom.remove(t);
        }
    }

    public static<T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static<T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T t: c1){
            if (c2.contains(t)){
                return true;
            }
        }
        return false;
    }

    //?????
    public static<T> List range(List<? extends Comparable> list, Object min, Object max) {
        Collections.sort(list);
        return list.subList(list.indexOf(min), list.indexOf(max) + 1);
    }

    public static<T> List range(List<? super T> list, Object min, Object max, Comparator comparator) {
        list.sort(comparator);
        return list.subList(list.indexOf(min), list.indexOf(max) + 1);
    }
}
