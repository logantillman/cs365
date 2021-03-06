// Author: Logan Tillman

package queue;

public class QueueEmptyException extends Exception {
    public QueueEmptyException() {
        System.out.println("queue empty: cannot dequeue");
    }
}
