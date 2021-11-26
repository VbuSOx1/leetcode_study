package other.No0404_SumOfLeftLeaves;

/**
 * @author weib
 * @date 2020-09-20 17:23
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.TreeNode treeNode =  solution.new TreeNode(1);
//        treeNode.left = solution.new TreeNode(2);
//        treeNode.left.left = solution.new TreeNode(5);
//        treeNode.left.right = solution.new TreeNode(5);
//
//        treeNode.right = solution.new TreeNode(3);
//        treeNode.right.left = solution.new TreeNode(7);
//        treeNode.right.right = solution.new TreeNode(6);
//        treeNode.right.right.left = solution.new TreeNode(7);

        System.out.println(solution.sumOfLeftLeaves(treeNode));

    }

}
