package sword_offer;

/**
 * @author weib
 * @date 2021-12-16 16:44
 * 54. 二叉搜索树的第k大节点
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class No_54 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    int sum = 0, kmax = 0;
    boolean isFind = false;
    public int kthLargest(TreeNode root, int k) {
        lur(root, k);
        return kmax;
    }

    public void lur(TreeNode cur, int k) {
        if (cur == null || isFind){
            return;
        }
        lur(cur.right, k);
        if (++sum == k) {
            kmax = cur.val;
            isFind = true;
            return;
        }
        lur(cur.left, k);
    }
}
