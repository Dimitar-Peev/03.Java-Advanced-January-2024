package _08_Generics._01_Lab._01_JarOfT;

public class Main {
    public static void main(String[] args) {

        Jar<String> jar = new Jar<>();

        jar.add("Ruse");
        jar.add("Sofia");
        jar.add("Plovdiv");

        System.out.println(jar.remove());
    }
}
