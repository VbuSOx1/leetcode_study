package sword_offer;

import java.util.*;

/**
 * @author weib
 * @date 2021-12-07 22:33
 * 32 - III. 从上到下打印二叉树 III
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */
public class No_32_III {
    public class TreeNode {
        int val;
        No_32_III.TreeNode left;
        No_32_III.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    List<List<Integer>> node = new ArrayList();

    public List<List<Integer>> levelOrder(TreeNode root) {
        lei(root, 0);
        for (int i = 1; i < node.size(); i+=2){
            Collections.reverse(node.get(i));
        }
        return node;
    }

    public void lei(TreeNode root, int k) {
        if (root != null) {
            if (node.size() <= k) {
                node.add(new ArrayList());
            }
            node.get(k).add(root.val);
            lei(root.left, k + 1);
            lei(root.right, k + 1);
        }
    }

}
