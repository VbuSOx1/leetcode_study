package sword_offer;

/**
 * @author weib
 * @date 2021-12-22 10:51
 * 65. 不用加减乘除做加法
 * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * 机组里面的 加法器 的逻辑运算 不过忘光了
 */
public class No_65 {
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
}
