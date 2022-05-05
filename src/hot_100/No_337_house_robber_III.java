package hot_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author weib
 * @date 2022-05-05 16:23
 * https://leetcode-cn.com/problems/house-robber-iii/
 * 337. 打家劫舍 III
 * 动态规划
 */
public class No_337_house_robber_III {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int rob(TreeNode root) {

        HashMap<TreeNode, List<Integer>> dp = new HashMap<>();
        return rob(root, dp, true);
    }

    public int rob(TreeNode root, HashMap<TreeNode, List<Integer>> dp, boolean robable) {
        if (root == null) {
            return 0;
        }
        if (dp.get(root) != null) {
            if (robable) {
                return dp.get(root).get(1);
            }
            return dp.get(root).get(0);
        }
        int maxNoRob = rob(root.left, dp, true) + rob(root.right, dp, true) ;
        int maxRob = rob(root.left, dp, false) + rob(root.right, dp, false) + root.val;
        List<Integer> max = new ArrayList<Integer>();
        max.add(maxNoRob);
        max.add(maxRob);
        dp.put(root, max);
        if (robable) {
            return Math.max(maxNoRob, maxRob);
        }
        return maxNoRob;
    }
}
