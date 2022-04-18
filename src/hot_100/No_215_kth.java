package hot_100;


import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author weib
 * @date 2022-04-18 15:25
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 215. 数组中的第K个最大元素
 * 小根堆
 */
public class No_215_kth {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
                continue;
            }
            if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
        return minHeap.poll();
    }

    @Test
    public void test(){
        int[] t = {3,2,1,5,6,4};
        System.out.println(findKthLargest(t, 2));;
    }
}
