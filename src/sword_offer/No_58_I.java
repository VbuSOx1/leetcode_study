package sword_offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author weib
 * @date 2021-12-14 19:18
 * 58 - I. 翻转单词顺序
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */
public class No_58_I {
    public String reverseWords(String s) {
        if (s.equals("")) {
            return "";
        }

        String[] result = s.split(" ");
        List<String> rList = new ArrayList<>();
        for (int i = result.length - 1; i >=0; i--) {
            String s1 = result[i];
            if("".equals(s1) || " ".equals(s1) || s1 == null){
                continue;
            }
            rList.add(" ");
            rList.add(s1);
        }
        if (rList.size() > 0 ) {
            rList.remove(0);
        }

        StringBuilder sb = new StringBuilder();
        for (String s1 : rList) {
            sb.append(s1);
        }
        return sb.toString();
    }
}
