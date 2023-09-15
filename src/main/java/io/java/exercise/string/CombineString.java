package io.java.exercise.string;

import java.util.Arrays;
import java.util.Optional;

public class CombineString {

    public static void main(String[] args) {

        String[] data = {"nfoeho", "ncfjebhvureb", "mcihfvegroih"};
        Optional<String> result = Arrays.stream(data).reduce((a, b) -> a + '-' + b);
        result.ifPresent(System.out::println);
    }
}
