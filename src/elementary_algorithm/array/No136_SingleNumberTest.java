package elementary_algorithm.array;


import org.junit.Test;

/**
 * @author weib
 * @date 2020-12-11 10:39
 */
class No136_SingleNumberTest {

    @Test
    public void singleNumber() {
        int[] nums = {2, 7, 9, 10, 200, 3, 10, 2, 7, 88, 3, 200, 9};
        int result =  new No136_SingleNumber().singleNumber(nums);
        System.out.println(result);
    }
}