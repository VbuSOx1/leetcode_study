package elementary_algorithm.tree;

/**
 * @author weib
 * @date 2021-04-17 12:28
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class No108_Convert_Sorted_Array_to_Binary_Search_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = new TreeNode( nums[(nums.length)/2]);
        createChildren(nums, 0, nums.length - 1, (nums.length)/2, treeNode);
        return treeNode;
    }

    public void createChildren(int[] nums, int start, int end , int mid , TreeNode root){
        if(start >= end || mid < start || mid > end){
            return;
        }
        int leftMid = (start + mid - 1) / 2;
        root.left = new TreeNode(nums[leftMid]);
        createChildren(nums, start, mid - 1, leftMid, root.left);
        int rightMid = (mid + 1 + end) / 2;
        root.right = new TreeNode(nums[rightMid]);
        createChildren(nums, mid + 1, end, rightMid, root.right);
    }
}
