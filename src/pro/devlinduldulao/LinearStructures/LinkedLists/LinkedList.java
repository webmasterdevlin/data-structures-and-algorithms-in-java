package pro.devlinduldulao.LinearStructures.LinkedLists;

import java.util.NoSuchElementException;

class LinkedList {
    private Node first;
    private Node last;
    private int size;

    void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    void addLast(int item) {
        var node = new Node(item);
        if (isEmpty())
            last = first = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    void reverse() {
        if (isEmpty())
            return;

        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalArgumentException();

        var a = first;
        var b = first;
        for (var i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null) {
                throw new IllegalArgumentException();
            }
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }

        return a.value;
    }

    int size() {
        return size;
    }

    int[] toArray() {
        int[] array = new int[size];
        var current = first;
        var index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    boolean contains(int item) {
        return indexOf(item) != -1;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    private int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item)
                return index;

            current = current.next;
            index++;
        }
        return -1;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private class Node {
        private int value;
        private Node next;


        private Node(int value) {
            this.value = value;
        }
    }
}
