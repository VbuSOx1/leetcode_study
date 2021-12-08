package sword_offer;

import other.No0000_BaseDataStruct.TreeNode;

/**
 * @author weib
 * @date 2021-12-08 16:14
 * 28. 对称的二叉树
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 */
public class No_28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        rotate(root.left);
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode left, TreeNode right){
        if(left == null && right == null ){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val == right.val){
            return isSame(left.left, right.left) && isSame(left.right, right.right);
        }
        return false;
    }

    public void rotate(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        rotate(root.left);
        rotate(root.right);
    }
}
