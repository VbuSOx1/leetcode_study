package Array_and_String;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weib
 * @date 2021-11-28 16:16
 * 反转字符串里的字符
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class No151_Reverse_Words_in_a_String {
    public static String reverseWords(String s) {
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
        rList.remove(0);
        StringBuilder sb = new StringBuilder();
        for (String s1 : rList) {
            sb.append(s1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(reverseWords("a good   example"));
    }

}
