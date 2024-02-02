package _08_Generics._01_Lab._03_GenericScale;

public class Main {
    public static void main(String[] args) {

        Scale<Integer> scale = new Scale<>(15,15);
        System.out.println(scale.getHeavier());
        
        Scale<String> stringScale = new Scale<>("a", "f");
        System.out.println(stringScale.getHeavier());
    }
}
