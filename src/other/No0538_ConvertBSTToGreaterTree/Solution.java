package other.No0538_ConvertBSTToGreaterTree;

/**
 * @author weib
 * @date 2020-09-21 11:46
 */

/**
 * 538. Convert BST to Greater Tree
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to
 * the original key plus sum of all keys greater than the original key in BST.
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import other.No0000_BaseDataStruct.TreeNode;

import java.util.Stack;

/**
 *  解题思路： 由于是BST，所以其中序遍历为该树的递增序列,反之（按右中左遍历即为该树的递减序列）
 *  所以可以做一次 （右中左遍历），每个结点需要累加的值，即为已经遍历过的所有结点的总和。
 *  这样一次遍历可以完成该算法 时间复杂度为O(n)
 */
public class Solution {

    /**
     * 非递归实现（递归实现更简单）
     */
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode tempNode = root.right;
        int sum = 0;
        while(tempNode != null || !stack.empty()){
            if(tempNode !=null ){
                stack.push(tempNode);
                tempNode = tempNode.right;
            }else{
                tempNode = stack.pop();
                int tempVal = tempNode.val;
                tempNode.val += sum;
                sum += tempVal;
                tempNode = tempNode.left;
            }
        }
        return root;
    }



}
