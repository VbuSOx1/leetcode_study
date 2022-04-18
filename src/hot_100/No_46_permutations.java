package hot_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weib
 * @date 2022-03-21 11:47
 * https://leetcode-cn.com/problems/permutations/
 * 46. 全排列
 * 回溯
 */
public class No_46_permutations {

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[21];
        List<List<Integer>> res = new ArrayList();
        permute(nums, visited, res, new ArrayList<Integer>(), 0);
        return res;
    }

    public void permute(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> temp, int index) {
        if (index >= nums.length) {
            res.add(new ArrayList(temp));
            return;
        }
        for (int num : nums) {
            if (visited[num+10]) {
                continue;
            }
            visited[num+10] = true;
            temp.add(num);
            permute(nums, visited, res, temp, index+1);
            visited[num+10] = false;
            temp.remove(temp.size()-1);
        }
    }
}
