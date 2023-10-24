package io.java.exercise.hashmap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * The load factor is a measure of how full the hash table is allowed to get before its capacity is automatically increased.
 *
 * @param <K> - the type of keys maintained by this map
 * @param <V> – the type of mapped values
 */
public class HashTableSeparateChaining<K, V> implements Iterable<K> {

    private static final int DEFAULT_CAPACITY = 3;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private int capacity;
    private int threshold;
    private int size;
    private double maxLoadFactor;
    private LinkedList<Entry<K, V>>[] table;

    public HashTableSeparateChaining() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashTableSeparateChaining(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public HashTableSeparateChaining(int capacity, double maxLoadFactor) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity");
        }
        if (maxLoadFactor <= 0 || Double.isNaN(maxLoadFactor) || Double.isInfinite(maxLoadFactor)) {
            throw new IllegalArgumentException("Illegal threshold limit");
        }
        this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
        this.maxLoadFactor = maxLoadFactor;
        this.threshold = (int) (this.capacity * maxLoadFactor);
        table = new LinkedList[this.capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // Converts a hash value to an index. Essentially, this strips the
    // negative sign and places the hash value in the domain [0, capacity]
    private int normalizeIndex(int hashKey) {
        return (hashKey & 0x7FFFFFFF) % capacity;
    }

    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }


    @Override
    public Iterator<K> iterator() {
        return null;
    }

    static class Entry<K, V> {

        int hashCode;
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.hashCode = key.hashCode();
        }

        public boolean equals(Entry<K, V> that) {
            if (this.hashCode != that.hashCode) {
                return false;
            }
            return this.key.equals(that.key);
        }

        @Override
        public String toString() {
            return key + " => " + value;
        }
    }
}


