import java.util.ArrayList;

public class ArrayQueue implements Queue {
    ArrayList<Object> arrayList = new ArrayList<Object>();

    @Override
    public void add(Object o) {
        arrayList.add(o);
    }

    @Override
    public Object remove() {
        return arrayList.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }
}