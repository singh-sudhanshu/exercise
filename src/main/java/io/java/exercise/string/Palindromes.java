package io.java.exercise.string;

public class Palindromes {

    public static void main(String[] args) {
        String one = "abba";
        System.out.println(isPalindrome(one));

    }

    public static boolean isPalindrome(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return str.equals(stringBuilder.reverse().toString());
    }
}
