package Array_and_String;

/**
 * @author weib
 * @date 2021-11-26 21:19
 * 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 抄题解
 */
public class No5_Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    public String longestPalindrome2(String s) {
        int begin = 0;
        int max_length =  1;
        int len = s.length();
        if(len < 2){
            return s;
        }
        // isPalindrome[i][j] 代表 从 i到j是回文
        boolean[][] isPalindrome = new boolean[len][len];
        for(int i = 0; i < len; i++){
            isPalindrome[i][i] = true;
        }
        char[] sChars = s.toCharArray();
        // 步长
        for(int step = 2; step < len; step++){
            for(int i = 0; i < len; i++){
                int j = i + step - 1;
                if( j >= len){
                    break;
                }
                if(sChars[i] == sChars[j] && (step <= 3 || isPalindrome[i+1][j-1])){
                    isPalindrome[i][j] = true;
                    if(step > max_length){
                        begin = i;
                        max_length = step;
                    }
                }else {
                    isPalindrome[i][j] = false;
                }
            }
        }
        return s.substring(begin, begin+max_length);

    }














}
