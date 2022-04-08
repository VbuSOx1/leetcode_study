package hot_100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author weib
 * @date 2022-04-08 15:28
 * https://leetcode-cn.com/problems/word-break/
 * 139. 单词拆分
 * 动态规划
 */
public class No_139_word_break {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hset = new HashSet<String>(wordDict);
        boolean[] suc = new boolean[s.length()+1];
        suc[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (suc[j] && hset.contains(s.substring(j, i))) {
                    suc[i] = true;
                    break;
                }
            }
        }
        return suc[s.length()];
    }
}
