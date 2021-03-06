// Author: Logan Tillman

public class QueueEmptyException extends Exception {
    public QueueEmptyException() {
        System.out.println("queue empty: cannot dequeue");
    }
}
