package hot_100;

import java.util.*;

/**
 * @author weib
 * @date 2022-03-16 14:49
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class No_22_generate_parentheses {
    String[] map = {"", "()", "(())", "((()))", "(((())))", "((((()))))", "(((((())))))", "((((((()))))))", "(((((((())))))))"};
    Map<Integer, List<String>> nMap = new HashMap();
    public List<String> generateParenthesis(int n) {
        nMap.put(1, Arrays.asList(new String[]{"()"}));
        return generater(n);
    }

    public List<String> generater(int n){
        List<String> result = new ArrayList();
        if (n < 1) {
            return result;
        }
        if (nMap.get(n) != null) {
            return nMap.get(n);
        }
        for (int i = 1; i <= n; i++){
            List<String> nextStrs = generater(n-i);
            List<String> innerStrs = i == 1?nMap.get(1):generater(i-1);
            List<String> curStrs = i == 1?innerStrs:new ArrayList();
            if (i > 1) {
                for (String curStr : innerStrs){
                    curStr = "(" + curStr + ")";
                    curStrs.add(curStr);
                }
            }

            if (nextStrs.size() == 0) {
                result.addAll(curStrs);
            }
            for (String curStr : curStrs){
                for (String nstr : nextStrs){
                    result.add(curStr + nstr);
                }
            }
        }
        nMap.put(n, result);
        return result;
    }
}
