package elementary_algorithm.tree;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;

/**
 * @author weib
 * @date 2021-04-10 11:15
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 对称树
 * 把左子树对称旋转  然后和 右子树比较
 * 也可以不旋转
 */
public class No101_Symmetric_Tree {
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


    public boolean isSymmetric(TreeNode root) {
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

    @Test
    public void test(){

    }
}





















