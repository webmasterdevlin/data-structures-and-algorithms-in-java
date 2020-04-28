package pro.devlinduldulao;

import java.util.Arrays;

public class Stack {
    private int[] items = new int[5];
    private int count;

    public Stack() {
    }

    void push(int i) {
        if (count == items.length)
            throw new StackOverflowError();

        items[count++] = i;
    }

    int pop() {
        if (count == 0)
            throw new IllegalStateException();

        return items[--count];
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }

    int peek() {
        if (count == 0)
            throw new IllegalStateException();

        return items[count - 1];
    }

    boolean isEmpty() {
        return count == 0;
    }

}
