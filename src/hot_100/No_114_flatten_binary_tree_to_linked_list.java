package hot_100;

/**
 * @author weib
 * @date 2022-04-06 17:40
 * 114. 二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class No_114_flatten_binary_tree_to_linked_list {
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

    public void flatten(TreeNode root) {
        flattenRe(root);
    }

    public TreeNode flattenRe(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode lastLeft = flattenRe(root.left);
        TreeNode lastRight = flattenRe(root.right);
        if (lastLeft == null) {
            return lastRight;
        }
        TreeNode right = root.right;
        root.right = root.left;
        lastLeft.right = right;
        root.left = null;
        return lastRight==null?lastLeft:lastRight;
    }
}
