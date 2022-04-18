package hot_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weib
 * @date 2022-03-15 16:10
 * 11. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 自己想的是单调队列，但是最后有几个用例过不去，
 * 发现这个题目的正确解法应该是双指针
 */
public class No_11_container_with_most_water {
    /**
     * 自己的解法 错误的
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        List<Integer> startList = new ArrayList<>();
        startList.add(0);
        int curHeight = 0;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 1; i < height.length; i++) {
            curHeight = height[i];
            int firstIndex = 0;
            for (int j = 0; j < startList.size(); j++ ) {
                int start = startList.get(j);
                int curAre = (i-start) * Math.min(height[i], height[start]);
                if (curAre > maxArea){
                    firstIndex = j;
                    maxArea = curAre;
                }
            }
            // for (int j = 0; j < firstIndex; j++){
            //     startList.remove(0);
            // }
            if (curHeight >= startList.get(startList.size()-1)) {
                startList.add(i);
            }
        }
        return maxArea;
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public int maxAre2a(int[] height) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int minHeight = 0;
            max = Math.max(max, (right - left) * Math.min(height[left] , height[right]));
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
}
