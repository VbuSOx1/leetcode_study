package hot_100;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author weib
 * @date 2022-05-06 15:53
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 347. 前 K 个高频元素
 * 小根堆 + hashmap
 */
public class No_347_topK_frequent_elements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> map.get(a) - map.get(b));
        for (int i = 0; i < nums.length; i++) {
            // 频次
            Integer pc = map.get(nums[i]);
            if (pc == null) {
                pc = 0;
            }
            map.put(nums[i], ++pc);
        }
        for (Integer num : map.keySet()) {
            if (queue.size() == k && map.get(num) > map.get(queue.peek())) {
                queue.poll();
                queue.add(num);
            }
            if (queue.size() < k) {
                queue.add(num);
            }
        }
        return queue.stream().mapToInt(Integer::valueOf).toArray();

    }

    @Test
    public void test(){
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }


}
