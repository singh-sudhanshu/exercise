package io.java.exercise.systems.LRUCache;

public class Main {

    public static void main(String[] args) {
        LRUCache<Integer> cache = new LRUCache<>(3);
        cache.put("one", 11);
        cache.put("two", 22);
        cache.put("three", 33);
        Integer value = cache.get("one");
        System.out.println(value);
        cache.put("four", 44);
    }
}
