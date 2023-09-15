package io.java.exercise.string;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class ReverseString {

    public static void main(String[] args) {
        var res = reverseString("Test String needs to be reverted");
        System.out.println(res);
    }

    public static String reverse(String str) {
        if (Objects.isNull(str)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            result.insert(0, c);
        }
        return result.toString();
    }

    public static String reverseString(String str) {
        Optional<String> result = Stream.of(str.split("''")).reduce((a, b) ->
                b + a
        );
        return result.toString();
    }
}
