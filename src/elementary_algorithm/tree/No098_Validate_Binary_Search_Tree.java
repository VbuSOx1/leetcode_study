package elementary_algorithm.tree;

import org.junit.jupiter.api.Test;

/**
 * @author weib
 * @date 2021-04-09 22:33
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 验证二叉搜索树
 */
public class No098_Validate_Binary_Search_Tree {
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

    static long last = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val <= last){
            return false;
        }
        last = root.val;
        return isValidBST(root.right);
    }
    @Test
    public void test(){
        TreeNode root = new TreeNode(0);
        System.out.println(isValidBST(root));
    }

}
