package sword_offer;

/**
 * @author weib
 * @date 2021-12-21 11:02
 *  07. 重建二叉树
 *  https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 */
public class No_07 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) {
            return null;
        }
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int startpre, int endpre, int startin, int endin) {
        if (startpre > endpre ) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[startpre]);
        // root 在 中序遍历中的序号
        int i = startin;
        for (; i <= endin; i++) {
            if (inorder[i] == preorder[startpre]) {
                break;
            }
        }
        int leftNum = i - startin;
        int rightNum = endin - i;
        root.left = buildTree(preorder, inorder, startpre+1, startpre+leftNum, startin, i-1);
        root.right = buildTree(preorder, inorder, startpre+leftNum+1, endpre, i+1, endin);
        return root;
    }
}
