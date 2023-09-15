package io.java.exercise.fizbuzz;

/*
 * Write the program that console logs the number from 1 to n, but the multiple of 3 prints fizz and 5 prints buzz.
 *  If both then print fizzbuzz.
 * */

import java.util.stream.IntStream;

public class FizBuzz {

    public static void main(String[] args) {
        printFizzBuzz(16);
    }

    public static void printFizzBuzz(int integer) {

        if (integer < 0) {
            System.out.println("N/A");
        }

        IntStream.range(1, integer).forEach(value -> {
            if (value % 15 == 0) {
                System.out.println("fizzbuzz");
            } else if (value % 3 == 0) {
                System.out.println("fizz");
            } else if (value % 5 == 0) {
                System.out.println("buzz");
            } else {
                System.out.println(value);
            }
        });
    }
}
