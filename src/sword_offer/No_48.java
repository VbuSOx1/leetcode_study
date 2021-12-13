package sword_offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author weib
 * @date 2021-12-13 19:33
 * 48. 最长不含重复字符的子字符串
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class No_48 {


    public int lengthOfLongestSubstring(String s) {
        char[] schars = s.toCharArray();
        int max = 0;
        List<Character> cList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            int index = cList.indexOf(schars[i]);
            // 重复
            if (index != -1) {
                while (index-- >= 0) {
                    cList.remove(0);
                }
            }
            cList.add(schars[i]);
            if (max < cList.size()) {
                max = cList.size();
            }
        }
        return max;
    }
}
