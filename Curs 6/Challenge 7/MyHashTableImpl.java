public class MyHashTableImpl implements MyHashTable<String, String> {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private int size;
    private Entry[] table;

    public MyHashTableImpl() {
        size = 0;
        table = new Entry[INITIAL_CAPACITY];
    }

    private int hash(String key) {
        return key.hashCode() % table.length;
    }

    @Override
    public String get(String key) {
        int index = hash(key);
        for (Entry entry = table[index]; entry != null; entry = entry.next) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public void put(String key, String value) {
        int index = hash(key);
        for (Entry entry = table[index]; entry != null; entry = entry.next) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        Entry newEntry = new Entry(key, value, table[index]);
        table[index] = newEntry;
        size++;
        if ((double) size / table.length > LOAD_FACTOR) {
            resize();
        }
    }

    @Override
    public void remove(String key) {
        int index = hash(key);
        Entry prev = null;
        for (Entry entry = table[index]; entry != null; entry = entry.next) {
            if (entry.key.equals(key)) {
                if (prev == null) {
                    table[index] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                size--;
                return;
            }
            prev = entry;
        }
    }

    @Override
    public boolean containsKey(String key) {
        int index = hash(key);
        for (Entry entry = table[index]; entry != null; entry = entry.next) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize() {
        Entry[] oldTable = table;
        table = new Entry[2 * oldTable.length];
        size = 0;
        for (Entry entry : oldTable) {
            while (entry != null) {
                put(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }

    private static class Entry {
        String key;
        String value;
        Entry next;

        public Entry(String key, String value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
