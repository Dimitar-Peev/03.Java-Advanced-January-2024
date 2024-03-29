package _08_Generics._02_Exercise._05_GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Box<T extends Comparable<T>> {
    private List<T> data;

    public Box() {
        this.data = new ArrayList<>();
    }

    public void add(T input) {
        this.data.add(input);
    }

    public void swap(int index1, int index2) {
        T element = this.data.get(index1);
        this.data.set(index1, data.get(index2));
        this.data.set(index2, element);
    }

    public long countNumberOfGreaterElements(T element) {

        return this.data.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    @Override
    public String toString() {
        return data.stream().map(e -> String.format("%s: %s", e.getClass().getName(), e))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
