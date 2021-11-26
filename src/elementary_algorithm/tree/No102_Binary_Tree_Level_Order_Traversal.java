package elementary_algorithm.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author weib
 * @date 2021-04-11 22:45
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 层序遍历
 */
public class No102_Binary_Tree_Level_Order_Traversal {
    public class TreeNode {
        Integer val;
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

    /**
     * 我的这个写法超时，原因是创建了太多null 然后判断  看下面别人的写法
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(No000_BinaryTreeFactory.TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<No000_BinaryTreeFactory.TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 当前层节点数
        int curLevelNum = 1;
        // 当前层已遍历节点数
        int traverseNum = 0;
        List<Integer> levelNodeVal = new ArrayList<>();
        while(!queue.isEmpty()){
            if(traverseNum < curLevelNum){
                No000_BinaryTreeFactory.TreeNode node = queue.poll();
                traverseNum++;
                if(node != null){
                    levelNodeVal.add((Integer) node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                    continue;
                }
                queue.offer(null);
                queue.offer(null);
                continue;
            }
            result.add(levelNodeVal);
            levelNodeVal = new ArrayList<>();
            curLevelNum *= 2;
            traverseNum = 0;
            if(queueIsAllNull(queue)){
                return result;
            }
        }
        return result;
    }

    public boolean queueIsAllNull(Queue q){
        Queue p = new LinkedList(q);
        while(!p.isEmpty()){
            if(p.poll() == null){
                continue;
            }
            return false;
        }
        return true;
    }


    /**
     * 别人的写法  判断当前层有多少节点很巧妙
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while(count > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                count--;
            }
            res.add(list);
        }
        return res;
    }

    @Test
    public void test(){
        Integer[] num = {3,9,20,null,null,15,7};
        No000_BinaryTreeFactory.TreeNode root = No000_BinaryTreeFactory.createBinaryTree(num);
        List<List<Integer>> list = levelOrder(root);
        System.out.println();

    }
}
