package Array_and_String;

/**
 * @author weib
 * @date 2021-11-28 17:09
 * https://leetcode-cn.com/problems/reverse-string/
 * 翻转字符串
 */
public class No344_Reverse_String {

    public void reverseString(char[] s) {
        int length = s.length;
        for(int i = 0; i < length/2; i++){
            char temp = s[i];
            s[i] = s[length-1-i];
            s[length-1-i] = temp;
        }
    }
}
