package io.java.exercise.maxchar;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string, return the character that is used most in that string.
 * MaxChar is used to solve many other string related questions like
 * What is the most common character in the given string.
 * Does the string A has the same character as String B (is it anagram)
 * Does the given string has any repeated character.
 */
public class MaxChar {

    public static void main(String[] args) {
        System.out.println(getString("aaahgnnbbh4325"));
    }

    private static Character getString(String str) {
        Map<Character, Integer> lookup = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            if (lookup.containsKey(c)) {
                int value = lookup.get(c);
                lookup.put(c, value + 1);
            } else {
                lookup.put(c, 0);
            }
        }
        return Collections.max(lookup.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
