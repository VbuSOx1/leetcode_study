package sword_offer;

import org.junit.Test;
import other.No0000_BaseDataStruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author weib
 * @date 2021-12-08 13:16
 * 26. 树的子结构
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */
public class No_26 {
    /**
     * 别人的方法更简单 简洁，
     * 我是用 队列遍历了树，但实际上不用，浪费了入队出队的时间
      */

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) {
            return false;
        }
        return isSameStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

        // if (A == null || B == null) {
        //     return false;
        // }
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.add(A);

        // while (!queue.isEmpty()) {
        //     TreeNode p = queue.poll();
        //     if (p == null) {
        //         continue;
        //     }
        //     if (p.val == B.val && isSameStructure(p, B)) {
        //         return true;

        //     }
        //     queue.add(p.left);
        //     queue.add(p.right);
        // }
        // return false;
    }
    /**
     A >= B
     A < B false
     */
    public boolean isSameStructure(TreeNode A, TreeNode B){
        if (A == null && B != null) {
            return false;
        }
        if (B == null) {
            return true;
        }
        return A.val == B.val && isSameStructure(A.left, B.left) && isSameStructure(A.right, B.right);
    }

    @Test
    public void test(){
        TreeNode A = TreeNode.TestMethod.getBSTExample();
        TreeNode B = new TreeNode(4);
        B.left = new TreeNode(1);
        B.right = new TreeNode(5);
        System.out.println(isSubStructure(A, B));
    }
}
