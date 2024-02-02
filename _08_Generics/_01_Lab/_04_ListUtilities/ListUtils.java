package _08_Generics._01_Lab._04_ListUtilities;

import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>>	T getMin(List<T> list) {
        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }

        return list.stream().min(Comparable::compareTo).get();
    }

    public static <T extends Comparable<T>>	T getMax(List<T> list) {
        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }

        return list.stream().max(Comparable::compareTo).get();
    }
}
