package hot_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weib
 * @date 2022-03-31 22:02
 * https://leetcode-cn.com/problems/subsets/
        78. 子集
    回溯 或者遍历
 */
public class No_78_subSets {

    public List<List<Integer>> subsets(int[] nums) {
        int[] visit = new int[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        getResult(nums, visit, item, res);
        res.add(new ArrayList<>());
        return res;
    }

    public void getResult(int[] nums, int[] visit, List<Integer> item, List<List<Integer>> res) {
        List<Integer> useIndex = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] != 0) {
                continue;
            }
            useIndex.add(i);
            visit[i] = 1;
            item.add(nums[i]);
            res.add(new ArrayList(item));
            getResult(nums, visit, item, res);
            item.remove(item.size()-1);
        }
        for (int i : useIndex) {
            visit[i] = 0;
        }
    }


    /**
     * 这个方法更好 简单
     * @param nums
     * @return
     */
    public List<List<Integer>> subset2s(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>(); // 解集
        lists.add(new ArrayList<Integer>()); // 首先将空集加入解集中
        for(int i = 0; i < nums.length; i++){
            int size = lists.size(); // 当前子集数
            for(int j = 0; j < size; j++){
                List<Integer> newList = new ArrayList<>(lists.get(j));// 拷贝所有子集
                newList.add(nums[i]); // 向拷贝的子集中加入当前数形成新的子集
                lists.add(newList); // 向lists中加入新子集
            }
        }
        return lists;
    }
}
