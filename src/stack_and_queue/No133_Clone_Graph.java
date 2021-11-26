package stack_and_queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author weib
 * @date 2021-06-15 11:09
 * https://leetcode-cn.com/problems/clone-graph/
 * 克隆图 深拷贝
 *  DFS
 */
public class No133_Clone_Graph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    HashMap<Integer, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        // 已访问
        if(visited.containsKey(node.val)){
            return visited.get(node.val);
        }

        Node newNode = new Node(node.val);
        visited.put(node.val, newNode);
        for(Node nbr : node.neighbors){
            if(nbr != null){
                newNode.neighbors.add(cloneGraph(nbr));
            }
        }
        return newNode;
    }

}










