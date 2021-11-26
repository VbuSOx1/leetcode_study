package elementary_algorithm.string;

import com.sun.org.apache.regexp.internal.REUtil;

/**
 * @author weib
 * @date 2021-03-30 16:02
 * https://leetcode-cn.com/problems/valid-palindrome/
 * 判断回文串，跳过非字母
 */
public class No125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        s = s.toUpperCase();
        char[] cs = s.toCharArray();
        int startIndex = 0;
        int endIndex = cs.length - 1;
        while(startIndex <= endIndex){
            // 当前为非字母字符  || (cs[startIndex] > 90 && cs[startIndex] < 97)
            while(startIndex < cs.length && !isAlpha(cs[startIndex]) && !isNumber(cs[startIndex] ) ) {
                startIndex++;
            }
            // || (cs[endIndex] > 90 && cs[endIndex] < 97)
            while(endIndex > -1 && !isAlpha(cs[endIndex]) && !isNumber(cs[endIndex] )  ) {
                endIndex--;
            }
            if(startIndex >= endIndex){
                return true;
            }
            if( startIndex < cs.length && endIndex > -1  && cs[startIndex] == cs[endIndex]){
                startIndex++;
                endIndex--;
                continue;
            }
            return false;
        }
        return true;
    }

    // 是否大写字母
    boolean isAlpha(char c){
        if(c < 'A' || c > 'Z'){
            return false;
        }
        return true;
    }
    boolean isNumber(char c){
        if(c < '0' || c > '9'){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        No125_Valid_Palindrome No125_Valid_Palindrome = new No125_Valid_Palindrome();
        String s = "0P";
        System.out.println(No125_Valid_Palindrome.isPalindrome(s));

    }

}
