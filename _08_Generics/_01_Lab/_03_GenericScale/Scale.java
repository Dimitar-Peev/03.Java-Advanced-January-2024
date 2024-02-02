package _08_Generics._01_Lab._03_GenericScale;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        int compareResult = this.left.compareTo(this.right);

        if (compareResult == 0) {
            return null;
        }

        return compareResult > 0 ? this.left : this.right;
    }
}
