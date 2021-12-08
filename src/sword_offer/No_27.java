package sword_offer;

import other.No0000_BaseDataStruct.TreeNode;

/**
 * @author weib
 * @date 2021-12-08 16:09
 * 27. 二叉树的镜像
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 */
public class No_27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode rootJx = new TreeNode(root.val);
        rootJx.left = mirrorTree(root.right);
        rootJx.right = mirrorTree(root.left);
        return rootJx;
    }
}
