package sword_offer;

import java.util.HashMap;

/**
 * @author weib
 * @date 2021-12-19 22:10
 * 55 - II. 平衡二叉树
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 */
public class No_55_II {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    HashMap<TreeNode, Integer> heightMap = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (heightMap.get(root) != null) {
            return heightMap.get(root);
        }
        int leftH =  maxDepth(root.left);
        int rightH =  maxDepth(root.right);
        int height = Math.max(leftH, rightH) + 1;
        heightMap.put(root, height);
        return height;
    }
}
