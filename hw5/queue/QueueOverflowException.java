// Author: Logan Tillman

package queue;

public class QueueOverflowException extends Exception {
    Object item;

    public QueueOverflowException(Object item) {
        this.item = item;
        System.out.printf("queue full: cannot enqueue %s%n", item.toString());
    }

    public String getMessage() {
        return new String("queue full: cannot enqueue " + this.item.toString());
    }
}