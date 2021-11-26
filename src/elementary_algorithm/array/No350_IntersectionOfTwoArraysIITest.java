package elementary_algorithm.array;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author weib
 * @date 2020-12-13 11:16
 */
public class No350_IntersectionOfTwoArraysIITest {

    @Test
    public void intersect() {
        No350_IntersectionOfTwoArraysII n350 = new No350_IntersectionOfTwoArraysII();
        int[] a = {8,2,2,3,4,4,7,5,4};
        int[] b = {3,4,1,2,8,4};
        System.out.println(Arrays.toString(n350.intersect(a, b)));

    }
}