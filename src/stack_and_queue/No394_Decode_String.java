package stack_and_queue;

import org.junit.Test;

/**
 * @author weib
 * @date 2021-06-21 15:07
 *
 * https://leetcode-cn.com/problems/decode-string/
 *
 * 字符串解码
 *
 */
public class No394_Decode_String {

    // 这个解法 不能有嵌套 []
    public String decodeString1(String s) {
        StringBuffer result = new StringBuffer();
        int curIndex = 0;
        // 在括号中
        boolean inBrackets = false;
        // 重复
        int rep = 0;
        StringBuffer repStr = new StringBuffer();
        char[] ca = s.toCharArray();

        for(int i = 0; i < ca.length; i++){
            if(ca[i] <= '9' && ca[i] >= '0'){
                rep = ca[i] - '0';
                continue;
            }

            if(ca[i] == '['){
                inBrackets = true;
                continue;
            }

            if(ca[i] == ']'){
                inBrackets = false;
                while(rep > 0 ){
                    result.append(repStr);
                    rep--;
                }
                repStr = new StringBuffer();
                continue;
            }

            if(inBrackets){
                repStr.append(ca[i]);
                continue;
            }
            result.append(ca[i]);
        }
        return result.toString();
    }



    // 解决 嵌套  解决不了 数字为多位 如 100[leetcode], 已修改
    public String decodeString(String s) {
        String s1 = "1[" + s + "]";
        return decode(s1.toCharArray());
    }

    int index = 0;
    public String decode(char[] s){
        StringBuilder result = new StringBuilder();
        while(s[index] != '['){
            result.append(s[index++]);
        }
        int n = Integer.parseInt(result.toString());
        index++;
        result = new StringBuilder();
        StringBuilder repStr = new StringBuilder();

        while(index < s.length){
            if(s[index] <= '9' && s[index] >= '0'){
                repStr.append(decode(s));
                continue;
            }
            if(s[index] == ']'){
                index++;
                break;
            }
            repStr.append(s[index++]);
        }

        while(n > 0 ){
            result.append(repStr);
            n--;
        }
        return result.toString();
    }



    @Test
    public void tts(){

        System.out.println(decodeString("222[wqe]"));
    }


























}
