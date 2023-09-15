package io.java.exercise.systems.topkelements;

import java.util.*;

public class HeavyHitter {

    private final String identifier;
    private final Integer frequency;

    public HeavyHitter(String identifier, Integer frequency) {
        this.identifier = identifier;
        this.frequency = frequency;
    }

    public List<HeavyHitter> topK(String[] events, Integer times) {
        Map<String, Integer> frequencyTable = new HashMap<>();
        for (String event : events) {
            frequencyTable.put(event, frequencyTable.getOrDefault(event, 0) + 1);
        }
        // Now define a min heap to keep track of top k elements
        PriorityQueue<HeavyHitter> heap = new PriorityQueue<>(Comparator.comparing(e -> e.frequency));
        for (Map.Entry<String, Integer> entry : frequencyTable.entrySet()) {
            heap.offer(new HeavyHitter(entry.getKey(), entry.getValue()));
        }
        if (heap.size() > times) {
            heap.poll();
        }
        List<HeavyHitter> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        return result;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Integer getFrequency() {
        return frequency;
    }
}
