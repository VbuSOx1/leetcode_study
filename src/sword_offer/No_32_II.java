package sword_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author weib
 * @date 2021-12-07 21:43
 * 从上到下打印二叉树 II
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 */
public class No_32_II {
    public class TreeNode {
        int val;
        No_32_II.TreeNode left;
        No_32_II.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 这个代码更简洁
    List<List<Integer>> node = new ArrayList();

    public List<List<Integer>> levelOrder(TreeNode root) {
        lei(root, 0);
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

    /**
     * 这个是自己写的 繁琐一点
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> values= new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        // 判断队首是不是空 是空的话 就是一行结束了
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p == null){
                if (values.size() == 0) {
                    break;
                }
                result.add(values);
                values = new ArrayList();
                continue;
            }
            values.add(p.val);
            if (p.left != null) {
                queue.add(p.left);
            }
            if (p.right != null) {
                queue.add(p.right);
            }
            if (queue.peek() == null) {
                queue.add(null);
            }

        }
        return result;

    }


}
