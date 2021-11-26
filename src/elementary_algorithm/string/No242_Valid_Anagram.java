package elementary_algorithm.string;

/**
 * @author weib
 * @date 2021-03-29 17:39
 * https://leetcode-cn.com/problems/valid-anagram/
 * 有效字母异位
 * 用数组存26个字母 判断字符是否一样
 */
public class No242_Valid_Anagram {
    public static boolean isAnagram(String s, String t) {
        int[] abs = new int[26];
        for(char a : s.toCharArray()){
            abs[a - 'a']++;
        }
        for(char a : t.toCharArray()){
            abs[a - 'a']--;
        }
        for(int i : abs){
            if(i != 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));
    }

}
