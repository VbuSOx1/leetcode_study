package elementary_algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weib
 * @date 2021-03-27 17:24
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * 第一个唯一字符
 * 新建一个数组，大小等同于字符串长度，数组中每个元素代表，字符串中对应位置的字符出现的次数
 * 依次遍历，把下标存在hashmap里面（第一次出现的字符）
 * 当同一字符每次再出现，从hashmap中获取该字符的下标，然后让计数的数组里对应位置 ++
 * 最后依次遍历 计数数组 返回第一个值为1的元素下标就ok了
 */
public class No387_First_Unique_Character_in_a_String {

    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[chars.length];
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < chars.length; i++){
            if(hm.get(chars[i]) != null){
                count[hm.get(chars[i])] ++;
                continue;
            }
            hm.put(chars[i], i);
            count[i] = 1;

        }
        for(int i = 0; i < count.length; i++){
            if(count[i] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

/*
       别人的代码：只遍历26个字符
 */
    class Solution {
        public int firstUniqChar(String s) {
            if (s.length() <= 26) {
                int[] chars = new int[26];
                for (char c : s.toCharArray()) {
                    chars[c - 'a'] += 1;
                }
                for (int i = 0; i < s.length(); ++i) {
                    if (chars[s.charAt(i) - 'a'] == 1) {
                        return i;
                    }
                }
            }
            //只遍历26个字母，使用indexOf函数检查字符索引
            int result = -1;
            for (char c = 'a'; c <= 'z'; ++c) {
                int pre = s.indexOf(c);
                // s包含该字符并且只出现一次
                if (pre != -1 && pre == s.lastIndexOf(c)) {
                    // 取最前面的位置
                    result = (result == -1 || result > pre) ? pre : result;
                }
            }
            return result;
        }
    }



}
