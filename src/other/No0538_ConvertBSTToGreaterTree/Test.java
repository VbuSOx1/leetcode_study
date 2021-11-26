package other.No0538_ConvertBSTToGreaterTree;


import other.No0000_BaseDataStruct.TreeNode;

/**
 * @author weib
 * @date 2020-09-23 14:19
 */
public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = TreeNode.TestMethod.getBSTExample();
        TreeNode.TestMethod.LDRPrint(treeNode);
        TreeNode result = solution.convertBST(treeNode);
        TreeNode.TestMethod.LDRPrint(result);

    }
}
