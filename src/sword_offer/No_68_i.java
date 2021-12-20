package sword_offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weib
 * @date 2021-12-20 19:19
 *  68 - I. 二叉搜索树的最近公共祖先
 *  https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 *
 *  这题搞错了 ，想复杂了 这个是二叉搜索树，我的解法是普通树的解法。
 *  二叉搜索树判断公共节点 只需要找到一个点 大于其中一个 小于另一个就行 如果大于两个数 则公共节点在左边，反之在右边
 */
public class No_68_i {
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
