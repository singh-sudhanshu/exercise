package io.java.exercise.queue;

import java.util.*;

/**
 * A min priority queue implementation using binary heap
 * To implement the priority queue, we need heap because heap gives the best possible time complexity.
 * PQs are abstract data types. It can be implemented using unsorted LinkedList as well but the time complexity
 * will not be the best.
 *
 * @param <E>
 */

public class PriorityQueue<E extends Comparable<E>> {

    private int heapSize = 0;
    private int heapCapacity = 0;

    private final List<E> heap;
    private final Map<E, TreeSet<Integer>> map = new HashMap<>();

    public PriorityQueue() {
        this(1);
    }

    public PriorityQueue(int size) {
        heap = new ArrayList<>(size);
    }

    // Building heap using array
    public PriorityQueue(E[] elements) {
        this(elements.length);
        heapCapacity = heapSize = elements.length;
        // Place all the elements into the heap
        for (int i = 0; i < heapSize; i++) {
            heap.add(elements[i]);
            addMap(elements[i], i);
        }

        //heapify the structure O(n)
        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--) {
            sink(i);
        }
    }

    public PriorityQueue(Collection<E> elements) {
        this(elements.size());
        for (E element : elements) {
            add(element);
        }
    }

    public void add(E element) {
        if (null == element) {
            throw new IllegalArgumentException("element is null");
        }
        if (heapSize < heapCapacity) {
            heap.set(heapSize, element);
        } else {
            heap.add(element);
            heapCapacity++;
        }
        // add to map
        addMap(element, heapSize);

        //Swim the element
        swim(heapSize);
        heapSize++;
    }

    private boolean less(int i, int j) {
        var it = heap.get(i);
        var that = heap.get(j);
        return it.compareTo(that) <= 0;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public void clear() {
        for (int i = 0; i < heapCapacity; i++) {
            heap.set(i, null);
        }
        map.clear();
        heapSize = 0;
    }

    public int size() {
        return heapSize;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    public E poll() {
        return removeAt(0);
    }

    public boolean contains(E node) {
        return map.containsKey(node);
    }

    // Bottom down the element
    private void sink(int k) {
        while (true) {
            // find the left and right children
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int smallest = left;
            if (right < heapSize && less(right, left)) {
                smallest = right;
            }
            if (left >= heapSize || less(k, smallest)) {
                break;
            }
            swap(smallest, k);
            k = smallest;
        }
    }

    //Bottom up the node O(log(n))
    private void swim(int k) {

        // Grab the index of next parent WRT to k
        int parent = (k - 1) / 2;

        // Swap the element with parent until it reaches to root and element is less than parent
        while (k > 0 && less(k, parent)) {
            swap(parent, k);
            // After swapping k becomes the new parent
            k = parent;
            // Grab the index of next parent WRT to k
            parent = (k - 1) / 2;
        }
    }

    private void swap(int i, int j) {
        var i_element = heap.get(i);
        var j_element = heap.get(j);
        heap.set(i, j_element);
        heap.set(j, i_element);
        // swap elements in map as well
        swapMap(i_element, j_element, i, j);
    }

    public boolean remove(E element) {
        if (element == null) {
            return false;
        }
        Integer index = mapGet(element);
        if (index != null) {
            removeAt(index);
        }
        return index != null;
    }

    // removes element at particular index
    private E removeAt(int i) {
        if (isEmpty()) {
            return null;
        }
        heapSize--;
        E removedElement = heap.get(i);
        swap(i, heapSize);
        heap.set(heapSize, null);
        mapRemove(removedElement, heapSize);

        if (i == heapSize) {
            return removedElement;
        }
        E element = heap.get(i);
        // try sinking
        sink(i);
        // if sinking did not work then try swimming
        if (heap.get(i).equals(element)) {
            swim(i);
        }
        return removedElement;
    }

    public boolean isMinHeap(int k) {
        if (k >= heapSize) {
            return true;
        }
        int left = 2 * k + 1;
        int right = 2 * k + 2;

        if (left < heapSize && !less(k, left)) {
            return false;
        }
        if (right < heapSize && !less(k, right)) {
            return false;
        }
        return isMinHeap(left) && isMinHeap(right);
    }

    private void addMap(E element, int i) {
        TreeSet<Integer> indexes = map.get(element);
        if (indexes == null) {
            indexes = new TreeSet<>();
            indexes.add(i);
            map.put(element, indexes);
        }
        // duplicate value
        else {
            indexes.add(i);
        }
    }

    private void mapRemove(E removedElement, int i) {
        var indexes = map.get(removedElement);
        indexes.remove(i); // TreeSet takes O(log(n)) to remove an element
        if (indexes.isEmpty()) {
            map.remove(removedElement);
        }
    }

    private Integer mapGet(E element) {
        var indexes = map.get(element);
        if (indexes != null) {
            indexes.last();
        }
        return null;
    }

    private void swapMap(E iElement, E jElement, int i, int j) {
        Set<Integer> set1 = map.get(iElement);
        Set<Integer> set2 = map.get(jElement);

        set1.remove(i);
        set2.remove(j);

        set1.add(j);
        set2.add(i);
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
