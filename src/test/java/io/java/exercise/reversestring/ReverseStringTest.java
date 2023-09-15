package io.java.exercise.reversestring;

import io.java.exercise.string.ReverseString;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseStringTest {

    @Test
    public void test_reverse() {
        assertEquals("detrever eb ot sdeen gnirtS tseT", ReverseString.reverse("Test String needs to be reverted"));
    }

    @Test
    public void empty_string_test() {
        assertEquals("", ReverseString.reverse(null));
    }
}