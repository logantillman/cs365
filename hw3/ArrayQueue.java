import java.util.ArrayList;

public class ArrayQueue implements Queue {
    ArrayList<Object> arrayList = new ArrayList<Object>();

    void add(Object o) {
        arrayList.add(o);
    }

    Object remove() {
        return arrayList.remove(0);
    }

    boolean isEmpty() {
        return arrayList.isEmpty();
    }
}