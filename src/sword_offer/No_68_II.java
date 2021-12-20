package sword_offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weib
 * @date 2021-12-20 19:30
 * 68 - II. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class No_68_II {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> stackP = new ArrayList<>();
        List<TreeNode> stackQ = new ArrayList<>();
        getStack(root, p, stackP);
        getStack(root, q, stackQ);
        int i = 0;
        TreeNode result = null;
        while(true) {
            if (stackP.size() == i || stackQ.size() == i || stackP.get(i) != stackQ.get(i)) {
                return result;
            }
            result = stackQ.get(i++);
        }
    }

    public boolean getStack(TreeNode root, TreeNode k,  List<TreeNode> stack) {
        if (root == null)  {
            return false;
        }
        stack.add(root);
        if (k == root) {
            return true;
        }
        if (getStack(root.left, k, stack) || getStack(root.right, k, stack)) {
            return true;
        }
        stack.remove(stack.size() - 1);
        return false;
    }
}
