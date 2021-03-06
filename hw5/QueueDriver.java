// Author: Logan Tillman

import java.util.Scanner;

public class QueueDriver {
    QueueDriver() {
        Scanner console = new Scanner(System.in);
        Queue<String> myQueue = new Queue<String>(console.nextInt());

        while(console.hasNextLine()) {
            Scanner lineTokenizer = new Scanner(console.nextLine());
            String type = "";

            if (lineTokenizer.hasNext()) {
                type = lineTokenizer.next();
            }

            if (type.equals("enqueue")) {
                String item = lineTokenizer.next();
                try {
                    myQueue.enqueue(item);
                } catch(QueueOverflowException err) {

                }
            }
            else if (type.equals("dequeue")) {
                try {
                    String popped = myQueue.dequeue();
                    System.out.printf("dequeue: %s%n", popped);
                } catch(QueueEmptyException err) {

                }
            }
            else if (type.equals("print")) {
                System.out.println("queue contents");
                myQueue.printQueue();
            }

            lineTokenizer.close();
        }

        console.close();
    }

    public static void main(String[] args) {
        new QueueDriver();
    }
}
