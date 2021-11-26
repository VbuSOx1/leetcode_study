package elementary_algorithm.string;

/**
 * @author weib
 * @date 2021-04-01 21:37
 * https://leetcode-cn.com/problems/count-and-say/
 * 外观序列
 */
public class No038_Count_And_Say {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String lastString = countAndSay(n - 1);
        // 计数
        int count = 1;
        char curNum = lastString.charAt(0);
        StringBuffer result = new StringBuffer();
        for(int i = 1; i < lastString.length(); i++){
            if(lastString.charAt(i) == curNum){
                count++;
                continue;
            }
            result.append(count);
            result.append(curNum);
            count = 1;
            curNum = lastString.charAt(i);
        }
        result.append(count);
        result.append(curNum);
        return result.toString();
    }

    public static void main(String[] args) {
        No038_Count_And_Say No038 = new No038_Count_And_Say();
        System.out.println(No038.countAndSay(4));
    }

}
