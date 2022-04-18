package hot_100;

import java.util.HashMap;

/**
 * @author weib
 * @date 2022-04-15 16:31
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * 208. 实现 Trie (前缀树)
 */
public class No_208_implement_trie_prefix_tree {
    Tree tree;

    class Tree {
        char v;
        HashMap<Character, Tree> next;
        boolean isWord;
        Tree(){
            next = new HashMap<>();
        }
        Tree(char v) {
            this();
            this.v = v;
        }
    }


    public No_208_implement_trie_prefix_tree() {
        tree = new Tree();
    }

    public void insert(String word) {
        Tree node = tree;
        for (char c : word.toCharArray()) {
            if (node.next.get(c) != null) {
                node = node.next.get(c);
                continue;
            }
            Tree t = new Tree(c);
            node.next.put(c, t);
            node = t;
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        Tree node = tree;
        for (char c : word.toCharArray()) {
            if (node.next.get(c) != null) {
                node = node.next.get(c);
                continue;
            }
            return false;
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        Tree node = tree;
        for (char c : prefix.toCharArray()) {
            if (node.next.get(c) != null) {
                node = node.next.get(c);
                continue;
            }
            return false;
        }
        return true;
    }
}
