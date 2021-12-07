package sword_offer;

/**
 * @author weib
 * @date 2021-12-07 21:01
 * 第一个只出现一次的字符
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class No_50 {
    public char firstUniqChar(String s) {
        if ("".equals(s)) {
            return ' ';
        }
        int[] count = new int[26];
        int i = 0;
        while(i < s.length()) {
            char c = s.charAt(i++);
            count[c - 'a']++;
        }
        int min = 50000;
        char minC = ' ';
        for (int j = 0; j < 26; j++) {
            if (count[j] == 1){
                int index = s.indexOf((char)('a'+j));
                if (index < min) {
                    min = index;
                    minC = (char)('a'+j);
                }
            }
        }
        return minC;
    }
}
