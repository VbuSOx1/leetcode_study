package elementary_algorithm.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author weib
 * @date 2021-04-10 11:42
 * 创建二叉树的工厂类
 */
public class No000_BinaryTreeFactory {
    public static class TreeNode {
        Object val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(Object val) { this.val = val; }
        TreeNode(Object val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static enum TraverseMethod{
        DLR, LDR, LRD;
    };
    /**
     * 按层序遍历创建 [1,2,2,3,4,4,3]
     *              1
     *             2  2
     *           3 4  4 3
     * @param num
     * @return
     */
    public static TreeNode createBinaryTree(Object[] val){
        if(val == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode();
        queue.offer(root);
        root.val = val[0];
        for(int i = 1; i < val.length; i+=2){
            TreeNode p = queue.poll();
            if(val[i] != null){
                p.left = new TreeNode(val[i]);
                queue.offer(p.left);
            }
            if(val[i+1] != null ){
                p.right = new TreeNode(val[i+1]);
                queue.offer(p.right);
            }
        }
        return root;
    }

    public static void printBinaryTree(TreeNode root, TraverseMethod traverseMethod){
        switch (traverseMethod){
            case DLR : printByDLR(root);printEnter();break;
            case LDR : printByLDR(root);printEnter();break;
            case LRD : printByLRD(root);printEnter();break;
            default :;
        }
    }

    private static void printEnter(){
        System.out.println();
    }
    /**
     * 前序遍历
     * @param root
     */
    private static void printByDLR(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        printByDLR(root.left);
        printByDLR(root.right);
    }


    /**
     * 中序遍历
     * @param root
     */
    private static void printByLDR(TreeNode root){
        if(root == null){
            return;
        }
        printByLDR(root.left);
        System.out.print(root.val + " ");
        printByLDR(root.right);
    }

    /**
     * 后序遍历
     * @param root
     */
    private static void printByLRD(TreeNode root){
        if(root == null){
            return;
        }
        printByLRD(root.left);
        printByLRD(root.right);
        System.out.print(root.val + " ");
    }


    @Test
    public void test(){
        Integer[] num = {3,9,20,null,null,15,7};
        TreeNode root = createBinaryTree(num);
        printBinaryTree(root, TraverseMethod.DLR);
        printBinaryTree(root, TraverseMethod.LRD);
        printBinaryTree(root, TraverseMethod.LDR);
    }

}
















