package hot_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weib
 * @date 2022-04-08 11:58
 * 128. 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 *
 *
用哈希表存储每个端点值对应连续区间的长度
若数已在哈希表中：跳过不做处理
若是新数加入：
取出其左右相邻数已有的连续区间长度 left 和 right
计算当前数的区间长度为：cur_length = left + right + 1
根据 cur_length 更新最大长度 max_length 的值
更新区间两端点的长度值

 */
public class No_128_longest_consecutive_sequence {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                int left = map.getOrDefault(nums[i]-1, 0);
                int right = map.getOrDefault(nums[i]+1, 0);
                int curLength = left + right + 1;
                if (curLength > max) {
                    max = curLength;
                }
                map.put(nums[i], curLength);
                map.put(nums[i]-left, curLength);
                map.put(nums[i]+right, curLength);
            }
        }
        return max;
    }
}
