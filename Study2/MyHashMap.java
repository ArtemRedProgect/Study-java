public class MyHashMap<K, V> {

    private static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private Node<K, V>[] table;
    private int size;
    private int threshold;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        this.table = new Node[DEFAULT_CAPACITY];
        this.size = 0;
        this.threshold = (int) (DEFAULT_CAPACITY * LOAD_FACTOR); // 16 * 0.75 = 12
    }

    public int size() {
        return this.size;
    }

    private int hash(Object key) {
        if (key == null) return 0;
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }

    private int getIndex(int hash, int length) {
        return (length - 1) & hash;
    }

    public V get(K key) {
        int hash = hash(key);
        int index = getIndex(hash, table.length);

        Node<K, V> current = table[index];

        while (current != null) {
            if (current.hash == hash && (current.key == key || (key != null && key.equals(current.key)))) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void put(K key, V value) {
        int hash = hash(key);
        int index = getIndex(hash, table.length);

        Node<K, V> head = table[index];
        if (head == null) {
            table[index] = new Node<>(hash, key, value, null);
            size++;
            checkResize();
            return;
        }

        Node<K, V> current = head;
        while (current != null) {
            if (current.hash == hash && (current.key == key || (key != null && key.equals(current.key)))) {
                current.value = value;
                return;
            }

            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        current.next = new Node<>(hash, key, value, null);
        size++;

        checkResize();
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int oldCapacity = table.length;
        int newCapacity = oldCapacity * 2;

        Node<K, V>[] oldTable = table;
        table = new Node[newCapacity];
        threshold = (int) (newCapacity * LOAD_FACTOR);
        for (int i = 0; i < oldCapacity; i++) {
            Node<K, V> current = oldTable[i];

            while (current != null) {
                Node<K, V> nextNode = current.next;

                int newIndex = getIndex(current.hash, newCapacity);

                current.next = table[newIndex];
                table[newIndex] = current;

                current = nextNode;
            }
        }
    }


    private void checkResize() {
        if (size > threshold) {
            resize();
        }
    }


}
