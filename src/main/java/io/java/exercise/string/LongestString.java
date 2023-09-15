package io.java.exercise.string;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LongestString {

    public static void main(String[] args) {

        List<String> data = Arrays.asList("Test", "cnuiegdiehuw", "tysbsahyu");
        Optional<String> result = data.stream().reduce((a, b) ->
            a.length() > b.length() ? a : b
        );
        result.ifPresent(System.out::println);
    }

}
