package pro.devlinduldulao.LinearStructures.Queues;

import java.util.Stack;

public class QueueWithTwoStacks {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> fakeQueue = new Stack<>();


    void enqueue(int item) {
        stack.push(item);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        moveStackToFakeQueue();

        return fakeQueue.pop();
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        moveStackToFakeQueue();

        return fakeQueue.peek();
    }

    private void moveStackToFakeQueue() {
        if (fakeQueue.isEmpty()) {
            while (!stack.isEmpty())
                fakeQueue.push(stack.pop());
        }
    }
    
    public boolean isEmpty() {
        return (stack.isEmpty() && fakeQueue.isEmpty());
    }
}
