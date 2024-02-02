package _08_Generics._01_Lab._02_GenericArrayCreator;

public class Main {
    public static void main(String[] args) {

        Integer[] arr = ArrayCreator.create(5, 0);
        String[] arrString = ArrayCreator.create(5, "0");
        Double[] arrDouble = ArrayCreator.create(Double.class,5, 0.0d);

    }
}
