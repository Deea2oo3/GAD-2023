public class MyArrayList<T> implements MyArrayListInterface<T> {

    private T[] array;
    private int size;

    public MyArrayList() {
        array = (T[]) new Object[10];
        size = 0;
    }

    @Override
    public void add(T e) {
        if (size == array.length) {
            T[] newArray = (T[]) new Object[2*size];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = e;
        size++;
    }

    @Override
    public void remove(T e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) {
                for (int j = i+1; j < size; j++) {
                    array[j-1] = array[j];
                }
                size--;
                array[size] = null;
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
        array[index] = e;
    }

    @Override
    public int size() {
        return size;
    }

}