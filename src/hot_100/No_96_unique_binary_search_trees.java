package hot_100;

/**
 * @author weib
 * @date 2022-04-06 16:40
 * 96. 不同的二叉搜索树
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class No_96_unique_binary_search_trees {
    // 自己写的错了 抄的

    public int numTrees(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
