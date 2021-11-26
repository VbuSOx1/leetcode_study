package elementary_algorithm.sort_and_search;

/**
 * @author weib
 * @date 2021-04-18 13:43
 * https://leetcode-cn.com/problems/first-bad-version/
 * 第一个错误的版本
 *
 * 二分
 */
public class No278_First_Bad_Version {

    public int firstBadVersion(int n) {
        long start = 1;
        long end = n;
        long mid = 0;
        while(start < end){
            // 这里用 start +（end - start）/ 2
            mid = (start + end) / 2;
            if(isBadVersion((int)mid)){
                end = mid - 1;
                continue;
            }
            start = mid + 1;
        }
        if(isBadVersion((int)start)){
            return (int)start;
        }
        return (int)start + 1;

    }

    public boolean isBadVersion(int n){
        return true;
    }
}
