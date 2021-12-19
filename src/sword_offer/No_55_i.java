package sword_offer;

/**
 * @author weib
 * @date 2021-12-19 22:00
 * 55 - I. 二叉树的深度
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 */
public class No_55_i {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH =  maxDepth(root.left);
        int rightH =  maxDepth(root.right);
        return Math.max(leftH, rightH) + 1;

    }
}
