package other.No0000_BaseDataStruct;

/**
 * @author weib
 * @date 2020-09-21 11:51
 * 二叉树结构  和遍历方法
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static class TestMethod{
        /**
         * 前序输出 DLR
         */
        public static void DLRPrint(TreeNode t){
            System.out.print("前序遍历： ");
            DLR(t);
            System.out.println(" ");
        }
        public static void DLR(TreeNode t){
            if(t == null) return;
            System.out.print(t.val + " ");
            DLR(t.left);
            DLR(t.right);
        }


        /**
         * 中序输出 LDR
         */
        public static void LDRPrint(TreeNode t){
            System.out.print("中序遍历： ");
            LDR(t);
            System.out.println(" ");

        }
        private static void LDR(TreeNode t){
            if(t == null) return;
            LDR(t.left);
            System.out.print(t.val + " ");
            LDR(t.right);
        }
        /**
         * 后序遍历 LRD
         */
        public static void LRDPrint(TreeNode t){
            System.out.print("后序遍历： ");
            LRD(t);
            System.out.println(" ");
        }
        private static void LRD(TreeNode t){
            if(t == null) return;
            LRD(t.left);
            LRD(t.right);
            System.out.print(t.val + " ");
        }


        /**
         * 获取一个BST(二叉搜索树)
         *              9
         *             / \
         *           7    12
         *         / \    / \
         *       4   8   10  19
         *     / \        \
         *    1   5        11
         */
        public static TreeNode getBSTExample()
        {
            TreeNode treeNode = new TreeNode(9);
            treeNode.left = new TreeNode(7);
            treeNode.left.left = new TreeNode(4);
            treeNode.left.left.left = new TreeNode(1);
            treeNode.left.left.right = new TreeNode(5);
            treeNode.left.right = new TreeNode(8);

            treeNode.right = new TreeNode(12);
            treeNode.right.left = new TreeNode(10);
            treeNode.right.left.right = new TreeNode(11);
            treeNode.right.right = new TreeNode(19);
            return treeNode;
        }

    }
}
