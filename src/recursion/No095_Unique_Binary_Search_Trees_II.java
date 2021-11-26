package recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author weib
 * @date 2021-05-20 10:11
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 不同的二叉搜索数II
 *
 * 递归求每个点的子树
 *
 * 别人的代码：当不存在字数时 在list里面 add（null）
 *
 */
public class No095_Unique_Binary_Search_Trees_II {
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

    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end){
        List<TreeNode> tree = new ArrayList<>();
        for(int i = start; i <= end; i++){
            List<TreeNode> leftChildren = generate(start, i - 1);
            List<TreeNode> rightChildren = generate(i + 1, end);
            for(TreeNode lc : leftChildren){
                for(TreeNode lr : rightChildren){
                    TreeNode r = new TreeNode(i);
                    r.left = lc;
                    r.right = lr;
                    tree.add(r);
                }
                if(rightChildren.size() == 0){
                    TreeNode r = new TreeNode(i);
                    r.left = lc;
                    tree.add(r);
                }
            }
            if(leftChildren.size() == 0 && rightChildren.size() != 0){
                for(TreeNode lr : rightChildren){
                    TreeNode r = new TreeNode(i);
                    r.right = lr;
                    tree.add(r);
                }
            }
            if(leftChildren.size() == 0 && rightChildren.size() == 0){
                tree.add(new TreeNode(i));
            }
        }
        return tree;
    }


    /**
     * 别人的代码  注意 别人 add(null)了，这样当左右子树为空时，也能进for循环创建节点，而不用像我那样写的很麻烦
     */
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            if(n==0) return new ArrayList<>();
            return dfs(1,n);
        }
        private List<TreeNode> dfs(int l,int r){
            List<TreeNode> res=new ArrayList<>();
            if(l>r){
                res.add(null);
                return res;
            }
            //枚举根节点
            for(int i=l;i<=r;i++){
                //根节点为i，此时左子树为 l~i-1
                List<TreeNode>left=dfs(l,i-1);
                //右子树为i+1~r
                List<TreeNode>right=dfs(i+1,r);
                for(TreeNode lh:left){
                    for(TreeNode rh:right){
                        TreeNode root=new TreeNode(i);
                        root.left=lh;
                        root.right=rh;
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }


    @Test
    public void test(){
        List<TreeNode> toot = new ArrayList<>();

        for (TreeNode b: toot){
            System.out.println(b);
        }
    }

}

























