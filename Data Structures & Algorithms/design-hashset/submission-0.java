class MyHashSet {

    private final MyHashMap<Integer, Boolean> map;

    public MyHashSet() {
        map = new MyHashMap<>();
    }
    
    public void add(int key) {
        map.put(key, true);
    }
    
    public void remove(int key) {
        map.delete(key);
    }
    
    public boolean contains(int key) {
        return map.containsKey(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

 class Entry<K, V> {
    private K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
 }

 class MyHashMap<K, V> {

    private ArrayList<Entry<K, V>>[] bucket;
    private int capacity;
    private int length;

    public MyHashMap() {
        capacity = 16;
        length = 0;
        bucket = new ArrayList[capacity];
    }

    private int calculateIndex(K key) {
        int h = key == null ? 0 : key.hashCode();
        int hash = h ^ (h >>> 16);
        int index = hash & (capacity - 1);
        return index;
    }

    public void put(K key, V value) {
        int index = calculateIndex(key);

        if (bucket[index] == null) {
            bucket[index] = new ArrayList<>();
            Entry<K, V> entry = new Entry(key, value);
            bucket[index].add(entry);
            return;
        }

        // only if key is null
        // if (key == null) {
        //     if (bucket[0] == null) {
        //         bucket[0] = new ArrayList<>();
        //         bucket[0].add(key, value);
        //         return;
        //     }

        //     Iterator iterator = bucket[0].iterator();
        //     while (iterator.hasNext()) {
        //         Entry<K, V> entry = iterator.next();
        //         if (entry.getKey() == null) {
        //             entry.setValue(value);
        //             return;
        //         } 
        //     }

        //     Entry<K, V> entry = new Entry(key, value);
        //     bucket[0].add(entry);
        //     return;
        // }

        Iterator iterator = bucket[index].iterator();
        while(iterator.hasNext()) {
            Entry<K, V> entry = (Entry<K, V>) iterator.next();
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        Entry<K, V> entry = new Entry(key, value);
        bucket[index].add(entry);
    }

    public void delete(K key) {
        int index = calculateIndex(key);
        if (bucket[index] == null) {
            return;
        }
        
        int length = bucket[index].size();
        for (int i = 0; i < length; i++) {
            if (bucket[index].get(i).getKey().equals(key)) {
                bucket[index].remove(i);
                return;
            }
        }
    }

    public boolean containsKey(K key) {
        int index = calculateIndex(key);
        if (bucket[index] == null) {
            return false;
        }

        Iterator iterator = bucket[index].iterator();
        while(iterator.hasNext()) {
            Entry<K, V> entry = (Entry<K, V>) iterator.next();
            if (entry.getKey().equals(key)) {
                return true;
            }
        }

        return false;
    }
    
 }
















