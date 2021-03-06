// Author: Logan Tillman

public class QueueOverflowException extends Exception {
    public QueueOverflowException(String item) {
        System.out.printf("queue full: cannot enqueue %s%n", item);
    }
}