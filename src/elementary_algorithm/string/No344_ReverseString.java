package elementary_algorithm.string;

import java.util.Arrays;

/**
 * @author weib
 * @date 2021-03-27 17:14
 * https://leetcode-cn.com/problems/reverse-string/
 * 反转字符串
 */
public class No344_ReverseString {

    public static void reverseString(char[] s) {
        int length = s.length;
        for(int i = 0; i < length/2; i++){
            char temp = s[i];
            s[i] = s[length-1-i];
            s[length-1-i] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'H','a','n','n','a','h'};
        System.out.println(Arrays.toString(s));
        reverseString(s);
        System.out.println(Arrays.toString(s));

    }
}
