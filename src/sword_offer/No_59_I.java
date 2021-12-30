package sword_offer;

import org.junit.Test;

import java.util.*;

/**
 * @author weib
 * @date 2021-12-30 10:00
 *  59 - I. 滑动窗口的最大值
 *  https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class No_59_I {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b-a);
        for (int i = 0; i < k; i++ ){
            queue.offer(nums[i]);
        }
        result[0] = queue.peek();
        for (int i = k; i < result.length; i++) {
            // if (nums[i-k] == queue.peek()) {
            //     queue.poll();
            // }
            queue.remove(nums[i-k]);
            queue.offer(nums[i]);
            result[i-k+1] = queue.peek();
        }
        return result;
    }

    /**
     * 单调队列解法
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除 deque 中对应的 nums[i-1]
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            // 保持 deque 递减
            while(!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if(i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }



    @Test
    public void test(){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(maxSlidingWindow(nums, 3));
    }
}
