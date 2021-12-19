package sword_offer;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author weib
 * @date 2021-12-19 20:45
 * 45. 把数组排成最小的数
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class No_45 {

    /**
     * 正确答案
     * @param nums
     * @return
     */
    public String minNumbe2r(int[] nums) {
        return IntStream.of(nums).mapToObj(String::valueOf).sorted(((o1, o2) -> (o1 + o2).compareTo(o2 + o1))).collect(Collectors.joining());
    }


    /**
    * 下面解法错了 数字计算会超出范围
     * 应该转换成String再进行比较
    */
    public String minNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int p = position(nums, low, high);
            quickSort(nums, low, p - 1);
            quickSort(nums, p + 1, high);
        }
    }



    public int position(int[] nums, int low, int high) {

        int pivot = nums[high];
        int point = low;
        for (int i = low; i < high; i++){
            if (isPre(nums[i], pivot)){
                swap(nums, i, point++);
            }
        }
        swap(nums, high, point);
        return point;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // a 是否应该在 b 前面
    public boolean isPre(int a, int b) {
        int al = (int) Math.log10(a)+1;
        int bl = (int) Math.log10(b)+1;
        return a * (int) Math.pow(10, bl) + b < a + b * (int) Math.pow(10, al);
    }


    @Test
    public void test(){
        int[] nums = new int[]{10,2};
        System.out.println(minNumber(nums));
    }

}
