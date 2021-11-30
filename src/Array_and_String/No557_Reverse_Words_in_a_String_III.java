package Array_and_String;

/**
 * @author weib
 * @date 2021-11-30 20:00
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * 反转字符串中的单词
 */
public class No557_Reverse_Words_in_a_String_III {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++){
            words[i] = reverse(words[i]);
        }
        StringBuffer sb = new StringBuffer();
        for (String word : words){
            sb.append(word);
            sb.append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public String reverse(String s){
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length/2; i++){
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }
}
