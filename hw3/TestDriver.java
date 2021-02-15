public class TestDriver {
    public TestDriver() {
        Queue queue = new ArrayQueue();
        queue.add(new Integer(3));
        queue.add(new Integer(10));
        queue.add(new Integer(5));

        System.out.println(queue.remove());
        System.out.println(queue.remove());

        queue.add(new Integer(6));
        queue.add(new Integer(9));
        queue.add(new Integer(12));

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    public static void main(String[] args) {
        new TestDriver();
    }
}