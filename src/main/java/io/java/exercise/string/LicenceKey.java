package io.java.exercise.string;

/**
 * You are given a license key represented as a string s that consists of only alphanumeric characters and dashes. The string is separated into n + 1 groups
 * by n dashes. You are also given an integer k.
 * We want to reformat the string s such that each group contains exactly k characters,
 * except for the first group, which could be shorter than k but still must contain at least one character.
 * Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.
 * Return the reformatted license key.
 * Input: s = "5F3Z-2e-9-w", k = 4
 * Output: "5F3Z-2E9W"
 * Explanation: The string s has been split into two parts, each part has 4 characters.
 * Note that the two extra dashes are not needed and can be removed.
 * Input: s = "2-5g-3-J", k = 2
 * Output: "2-5G-3J"
 * Explanation: The string s has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
 * 1 <= s.length <= 105
 * s consists of English letters, digits, and dashes '-'.
 * 1 <= k <= 104
 */

public class LicenceKey {

    // hints: start backwards because first group is variable
    // if - is found then ignore
    // insert dash when count is k

    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder result = new StringBuilder();
        int counter = 0;
        int i = s.length() - 1;
        while (i >= 0) {
            char current = Character.toUpperCase(s.charAt(i));
            if (current == '-') {
                i--;
            } else if (counter != 0 && counter % k == 0) {
                result.insert(0, '-');
                counter = 0;
                // i--; so that we don't loose the current character
            } else {
                result.insert(0, current);
                counter++;
                i--;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String result = licenseKeyFormatting("5F3Z-2e-9-w", 3);
        System.out.println(result);
    }


}
