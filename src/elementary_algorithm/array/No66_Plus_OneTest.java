package elementary_algorithm.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author weib
 * @date 2020-12-16 10:22
 */
class No66_Plus_OneTest {

    @Test
    void plusOne() {
        int[] a = {0};
        No66_Plus_One plus_one = new No66_Plus_One();
        System.out.println(Arrays.toString(plus_one.plusOne(a)));

    }
}