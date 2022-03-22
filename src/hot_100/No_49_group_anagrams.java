package hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author weib
 * @date 2022-03-22 11:20
 * https://leetcode-cn.com/problems/group-anagrams/
 * 49. 字母异位词分组
 * hash
 */
public class No_49_group_anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            char[] charStr = str.toCharArray();
            Arrays.sort(charStr);
            String sortedStr = new String(charStr);
            Integer index = map.get(sortedStr);
            if (index != null) {
                res.get(index).add(str);
                continue;
            }
            List<String> items = new ArrayList();
            items.add(str);
            res.add(items);
            map.put(sortedStr, res.size()-1);
        }
        return res;
    }
}
