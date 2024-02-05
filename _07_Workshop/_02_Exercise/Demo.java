package _07_Workshop._02_Exercise;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList myList = new DoublyLinkedList();

        // 1 2 3
        myList.addLast(1); // index 0
        myList.addLast(2);
        myList.addLast(3);
        myList.addLast(4);
        myList.addLast(5);

        System.out.println(myList.removeLast());

        myList.forEach(System.out::println);

        int[] ints = myList.toArray();

        System.out.printf("");
    }
}
