package elementary_algorithm.tree;

import java.util.Stack;

/**
 * @author weib
 * @date 2021-04-08 11:12
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 二叉树最大深度
 * 解题思路：前序遍历+栈/递归
 */
public class No104_Maximum_Depth_of_Binary_Tree {
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
    // 递归
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftNum = maxDepth(root.left);
        int rightNum = maxDepth(root.right);
        return 1 + (Math.max(leftNum, rightNum));

        // 一行
        // return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 栈 以下为错误代码  会死循环
    public int maxDepthStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int max = 0;
        TreeNode p = root;
        while(p != null || !stack.empty()){
            if(p != null){
                stack.push(p);
                p = p.left;
                if(max < stack.size()){
                    max = stack.size();
                }
                continue;
            }
            p = stack.peek().right;
            if(p == null){
                stack.pop();
            }
        }
        return max;
    }
}
