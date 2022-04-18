package hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weib
 * @date 2022-03-21 11:09
 * https://leetcode-cn.com/problems/combination-sum/
 * 39. 组合总和
 * 回溯加剪枝 这个算法 比我写的回溯要好 我的是递归暴力 虽说差不多，但是复杂度高在反复的往List里面add
 * 别人的算法更简洁
 */
public class No_39_combination_sum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    /**
     * 别人的
     * @param candidates
     * @param target
     * @param ans
     * @param combine
     * @param idx
     */
    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates, target, 0);
    }

    /**
     * 我的
     * @param candidates
     * @param target
     * @param firstIndex
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target, int firstIndex){
        List<List<Integer>> result = new ArrayList();
        if (firstIndex >= candidates.length || target <= 0){
            return result;
        }
        List<Integer> item = new ArrayList();
        for (int i = 0; i < 150; i++){
            int curValue = i*candidates[firstIndex];
            if (curValue > target) {
                return result;
            }
            if (i > 0) {
                item.add(candidates[firstIndex]);
            }
            if (curValue == target) {
                result.add(item);
                return result;
            }
            List<List<Integer>> postList = combinationSum(candidates, target-curValue, firstIndex+1);
            if (postList.size() == 0) {
                continue;
            }else{
                for (List<Integer> postItem : postList){
                    postItem.addAll(item);
                }
            }
            result.addAll(postList);
        }
        return result;
    }
}
