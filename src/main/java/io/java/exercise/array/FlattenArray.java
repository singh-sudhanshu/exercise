package io.java.exercise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/******************************************************************************
 Welcome to GDB Online.
 Code, Compile, Run and Debug online from anywhere in world.
 *******************************************************************************/
public class FlattenArray {

    public static void main(String[] args) throws Exception {
        Object[] array = {1, 2, new Object[]{3, 4, new Object[]{5}, 6, 7}, 8, 9, 10};
        var flattenedArray = flatten(array);
        System.out.println(Arrays.toString(flattenedArray));
    }

    public static Integer[] flatten(Object[] inputArray) {
        if (inputArray == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        for (Object element : inputArray) {
            if (element instanceof Integer) {
                result.add((Integer) element);
            } else if (element instanceof Object[]) {
                result.addAll(Arrays.asList(flatten((Object[]) element)));
            }
        }
        return result.toArray(new Integer[0]);
    }
}

