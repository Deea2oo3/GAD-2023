import java.util.NoSuchElementException;

public class ArrayCustomIterator {
    private final int[] array;
    private int currentIndex;

    public ArrayCustomIterator(int[] array) {
        this.array = array;
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < array.length;
    }

    public int next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the array.");
        }
        return array[currentIndex++];
    }
}

