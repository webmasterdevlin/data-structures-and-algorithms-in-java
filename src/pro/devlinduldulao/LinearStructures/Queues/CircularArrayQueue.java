package pro.devlinduldulao.LinearStructures.Queues;

import java.util.Arrays;

public class CircularArrayQueue {
    private int[] items;
    private int front;
    private int rear;
    private int count;

    public CircularArrayQueue(int capacity) {
        items = new int[capacity];
    }

    /*
     * [10,  20,  30,  40,  #]   delete the 1st two
     *  front               rear
     *
     * [#,  #,  30,  40,  #]     add 50 at the end
     *          front     rear
     *
     * [#,  #,  30,  40,  50]    then move the tail
     *  rear    front
     * */

    void enqueue(int item) {
        if (count == items.length)
            throw new IllegalStateException();

        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    int dequeue() {
        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
