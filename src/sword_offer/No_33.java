package sword_offer;

/**
 * @author weib
 * @date 2021-12-21 20:27
 *  33. 二叉搜索树的后序遍历序列
 *
 *
 *  https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */
public class No_33 {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length -1);

    }

    public boolean verifyPostorder(int[] postorder, int st, int end) {
        if (st >= end) {
            return true;
        }
        int pl = st;
        while (pl < end) {
            if (postorder[pl] > postorder[end]) {
                // pl指向第一个大于 end的下标
                break;
            }
            pl++;
        }
        int p = pl;
        while (p < end) {
            if (postorder[p] <= postorder[end]) {
                return false;
            }
            p++;
        }
        return verifyPostorder(postorder, st, pl-1) && verifyPostorder(postorder, pl, end-1);

    }
}
