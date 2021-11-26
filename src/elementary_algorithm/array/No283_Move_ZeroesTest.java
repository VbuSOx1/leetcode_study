package elementary_algorithm.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author weib
 * @date 2020-12-17 10:18
 */
class No283_Move_ZeroesTest {


    @Test
    void moveZeroes() {
        int[] nums = {2, 1, 2, 3, 6};
        No283_Move_Zeroes move_zeroes = new No283_Move_Zeroes();
        move_zeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}