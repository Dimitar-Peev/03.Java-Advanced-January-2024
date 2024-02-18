package _09_IteratorsAndComparators._02_Exercise._09_LinkedListTraversal;

import java.util.Iterator;

public class LinkedListTraversal implements Iterable<Integer>  {
    private static class MyNode {
        private MyNode next;
        private int element;

        public MyNode(int element) {
            this.setElement(element);
            this.next = null;
        }

        public void setElement(int element) {
            this.element = element;
        }
    }

    private MyNode head;
    private int size;

    public void add(int element) {
        MyNode newNode = new MyNode(element);
        newNode.next = null;

        if (this.size == 0) {
            this.head = newNode;
            size++;
        } else {
            MyNode last = this.head;

            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
            size++;
        }

    }


    public void remove(int key) {
        MyNode temp = head;
        MyNode prev = null;

        if (temp != null && temp.element == key) {
            head = temp.next;
            size--;
            return;
        }


        while (temp != null && temp.element != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        size--;
        prev.next = temp.next;
    }


    public int size() {
        return this.size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                int num = current.element;
                current = current.next;
                return num;
            }
        };
    }
}
