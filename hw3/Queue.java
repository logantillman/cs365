public interface Queue {
    void add(Object o);

    Object remove();

    boolean isEmpty();
}