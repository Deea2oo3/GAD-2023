public class MySet<T> implements MySetInterface<T> {

    private T[] array;
    private int size;

    public MySet(int capacity) {
        array = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void add(T e) {
        if (!contains(e)) {
            if (size == array.length) {
                throw new IllegalStateException("Set is full");
            }
            array[size] = e;
            size++;
        }
    }

    @Override
    public void remove(T e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) {
                array[i] = array[size-1];
                array[size-1] = null;
                size--;
                return;
            }
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return array[index];
    }

    @Override
    public void set(int index, T e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (contains(e)) {
            throw new IllegalArgumentException("Duplicate element");
        }
        array[index] = e;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

}