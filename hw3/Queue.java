// Author: Logan Tillman

public interface Queue {
    public void add(Object o);

    public Object remove();

    public boolean isEmpty();
}