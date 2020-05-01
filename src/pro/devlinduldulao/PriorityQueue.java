package pro.devlinduldulao;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items = new int[5];
    private int count;

    public void add(int item) {
        if (isFull())
            throw new IllegalStateException();
        /*
         * [1, 3, 4, #]   (2)
         * [1, 2, 3, 4]   (full)
         */
        int i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    private boolean isFull() {
        return items.length == count;
    }

    private int shiftItemsToInsert(int item) {
        //1st cycle    5               4
        //2nd cycle    4               3
        //and so on..
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item)
                items[i + 1] = items[i];
            else
                break;
        }
        return i + 1;
    }
}
