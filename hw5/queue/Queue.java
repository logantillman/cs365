// Author: Logan Tillman

package queue;

import java.util.ArrayList;

public class Queue<T> {
    int maxCapacity;
    T front;
    T back;
    ArrayList<T> data = new ArrayList<T>();

    Queue(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    void enqueue(T value) throws QueueOverflowException {
        if (data.size() == maxCapacity) {
            throw new QueueOverflowException(value);
        }

        if (data.size() == 0) {
            front = value;
        }
        data.add(value);
        back = value;
    }

    T dequeue() throws QueueEmptyException {
        if (data.size() == 0) {
            throw new QueueEmptyException();
        }
        T rv = front;
        data.remove(0);

        if (data.size() > 0) {
            front = data.get(0);
        }

        return rv;
    }

    void printQueue() {
        for (T item : data) {
            System.out.println(item);
        }
    }
}