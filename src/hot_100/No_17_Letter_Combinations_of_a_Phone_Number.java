package hot_100;

import java.util.*;

/**
 * @author weib
 * @date 2022-03-16 10:33
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 回溯
 */
public class No_17_Letter_Combinations_of_a_Phone_Number {
    String[][] map= {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"},
            {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};
    Map<Integer, List<String>> cache = new HashMap();
    public List<String> letterCombinations(String digits) {
        return getStringArr(digits, 0);
    }

    public List<String> getStringArr(String digits, int index){
        List<String> result = new ArrayList<>();
        if (index >= digits.length()) {
            return result;
        }
        if (cache.get(index) != null) {
            return cache.get(index);
        }
        // for (int i = index; i < digits.length; i++) {
        String[] curArr = map[digits.charAt(index) - '2'];
        if(index == digits.length() - 1) {
            return Arrays.asList(curArr);
        }
        for (String s : curArr) {
            List<String> nextStrings = getStringArr(digits, index+1);
            for (String nextStr : nextStrings) {
                result.add(s + nextStr);
            }
        }
        cache.put(index, result);
        return result;

        // }
    }
}
