package elementary_algorithm.other;

/**
 * @author weib
 * @date 2021-04-30 22:48
 * https://leetcode-cn.com/problems/hamming-distance/
 * 汉明距离
 */
public class No461_Hamming_Distance {
    public int hammingDistance(int x, int y) {
        return hammingWeight( x ^ y);
    }
    public int hammingWeight(int n) {
        int t = n;
        int count = t & 1;
        t = t >>> 1;
        while(t > 0){
            if((t & 1) == 1){
                count++;
            }
            t = t >>> 1;
        }
        return count;
    }
}
