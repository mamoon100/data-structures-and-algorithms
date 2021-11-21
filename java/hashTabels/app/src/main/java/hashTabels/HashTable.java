package hashTabels;


import java.util.Arrays;

public class HashTable<K, V> {
  private Bucket<K, V>[] table;
  private int size;
  private int capacity;

  public HashTable() {
    this.capacity = 1024;
    table = new Bucket[capacity];
  }

  public void add(K key, V value) {
    // to check if the size is bigger than the capacity
    if (size == capacity) setCapacity(capacity * 2);

    // to check if the key is already in the table
    if (!contains(key)) {
      table[hash(key)] = new Bucket<>(key, value);
      size++;
    } else table[hash(key)].setValue(value);

  }

  public V get(K key) {
    return table[hash(key)].getValue();
  }

  public boolean contains(K key) {
    return table[hash(key)] != null;
  }


  private int hash(K key) {
    int asciiSum = 0;
    for (int i = 0; i < key.toString().length(); i++) {
      asciiSum += key.toString().charAt(i);
    }
    return (asciiSum * 677) % capacity;
  }

  public Bucket<K, V>[] getTable() {
    return table;
  }

  public int size() {
    return size;
  }

  public int capacity() {
    return capacity;
  }

  private void setCapacity(int capacity) {
    Bucket<K, V>[] newTable = new Bucket[capacity];
    this.capacity = capacity;
    for (Bucket<K, V> kvBucket : table) {
      if (kvBucket != null) newTable[hash(kvBucket.getKey())] = kvBucket;
    }
    this.table = newTable;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    for (Bucket<K, V> bucket : table) {
      if (bucket != null) sb.append(bucket.toString()).append(", ");
    }
    if (sb.length() == 1) return "{}";
    return sb.substring(0, sb.toString().trim().length() - 1) + "}";
  }
}
