package other.No0404_SumOfLeftLeaves;

/**
 * @author weib
 * @date 2020-09-19 11:11
 */
/**
 * Find the sum of all left leaves in a given binary tree.
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * 解题思路： 通过前序遍历（递归实现）获取所有叶子节点
 * 进入右节点前，判断是否是叶子节点，如果是则不进入递归
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        if(root.right == null && root .left == null) return 0;
        return getSumOfLeftLeaves(root);

    }

    public int getSumOfLeftLeaves(TreeNode root){
        if(root == null ) return 0;
        int sum = 0;
        if(root.left == null && root.right == null)
            sum += root.val;
        sum += getSumOfLeftLeaves(root.left);
        if(root.right != null && (root.right.left != null || root.right.right != null))
        {
            sum += getSumOfLeftLeaves(root.right);
        }
        return sum;
    }

}