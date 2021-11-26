package stack_and_queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weib
 * @date 2021-06-20 14:59
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 中序遍历
 */
public class No94_Binary_Tree_Inorder_Traversal {

     // Definition for a binary tree node.
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

    List<Integer> arr = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        ldr(root);
        return arr;
    }


    public void ldr(TreeNode root){
        if(root == null){
            return;
        }
        ldr(root.left);
        arr.add(root.val);
        ldr(root.right);
    }
}
















