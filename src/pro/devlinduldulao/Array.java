package pro.devlinduldulao;

class Array {
    private int[] items;
    private int count;

    Array(int length) {
        items = new int[length];
    }

    void insert(int item) {
        if (items.length == count) {
            var newItems = new int[count * 2];
            System.arraycopy(items, 0, newItems, 0, count);

            items = newItems;
        }
        items[count++] = item;
    }

    void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        System.arraycopy(items, index + 1, items, index, count - index);

        count--;
    }

    public int indexOf(int item) {
        for (var i = 0; i < count; i++)
            if (items[i] == item)
                return i;

        return -1;
    }

    void print() {
        for (var i = 0; i < count; i++)
            System.out.println(items[i]);
    }
}
