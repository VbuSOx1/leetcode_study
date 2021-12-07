package sword_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author weib
 * @date 2021-12-07 21:27
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/submissions/
 * Offer 32 - I. 从上到下打印二叉树
 */
public class No_32_I {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            result.add(p.val);
            if (p.left != null) {
                queue.add(p.left);
            }
            if (p.right != null) {
                queue.add(p.right);
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();

    }
}
