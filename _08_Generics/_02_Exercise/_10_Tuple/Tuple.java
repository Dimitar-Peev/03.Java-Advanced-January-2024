package _08_Generics._02_Exercise._10_Tuple;

public class Tuple<F, S> {
    private F item1;
    private S item2;

    public Tuple(F item1, S item2) {
        this.setItem1(item1);
        this.setItem2(item2);
    }

    public void setItem1(F item1) {
        this.item1 = item1;
    }

    public void setItem2(S item2) {
        this.item2 = item2;
    }

    public F getItem1() {
        return item1;
    }

    public S getItem2() {
        return item2;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.item1, this.item2);
    }
}
