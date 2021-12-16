package sword_offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weib
 * @date 2021-12-16 15:33
 * 34. 二叉树中和为某一值的路径
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */
public class No_34 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSum(root, target, path, paths);
        return paths;
    }

    public void pathSum(TreeNode root, int target, List<Integer> path, List<List<Integer>> paths) {
        if (root == null) {
            return;
        }
        target -= root.val;
        path.add(root.val);
        // 叶子节点
        if (root.left == null && root.right == null) {
            if (target == 0) {
                List<Integer> p = new ArrayList(path);
                paths.add(p);
            }
            path.remove(path.size() - 1);
            return;
        }
        pathSum(root.left, target, path, paths);
        pathSum(root.right, target, path, paths);
        path.remove(path.size() - 1);
        return;
    }

}
