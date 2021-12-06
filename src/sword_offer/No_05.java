package sword_offer;

/**
 * @author weib
 * @date 2021-12-06 13:52
 * 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class No_05 {
    public String replaceSpace(String s) {

        StringBuilder sb = new StringBuilder();
        char[] strChar = s.toCharArray();
        for (int i = 0; i < strChar.length; i++){
            if (strChar[i] == ' '){
                sb.append("%20");
                continue;
            }
            sb.append(strChar[i]);
        }
        return sb.toString();
        //   return s.replaceAll(" ", "%20");
    }
}
