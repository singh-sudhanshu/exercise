package io.java.exercise.integer;

public class ReverseInt {

    public static void main(String[] args) {
        System.out.println(reverseInteger(-12345));
    }

    public static int reverseInteger(int integer) {
        int result = 0;
        while (integer != 0) {
            int lastDigit = integer % 10;
            result += lastDigit;
            result = result * 10;
            integer = integer / 10;
        }
        result = result / 10;
        return result;
    }
}
