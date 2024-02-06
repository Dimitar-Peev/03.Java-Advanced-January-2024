package _08_Generics._02_Exercise._02_GenericBoxOfInteger;

import java.util.Scanner;

public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.value.getClass().getName(), value.toString());
    }
}
