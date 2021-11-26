package elementary_algorithm.math;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author weib
 * @date 2021-04-21 14:42
 * https://leetcode-cn.com/problems/count-primes/
 * 计算质数
 */
public class No204_Count_Primes {
    // 超时
    public int countPrimes(int n) {
        int count = 0;
        for(int i = 2; i < n; i++){
            if(isPrimes(i)){
                count++;
            }
        }
        return count;

    }
    // 判断素数
    public boolean isPrimes(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }


    // 欸氏筛
    public int countPrimes2(int n) {
        int[] primes = new int[n + 1];
        Arrays.fill(primes, 1);
        int count = 0;
        for(int i = 2; i <= n; i++){
            if(primes[i] == 1){
                count++;
                for(long j = (long)i * i; j <= n; j += i){
                    primes[(int) j] = 0;
                }
            }
        }
        return count;

    }


    @Test
    public void test(){
        System.out.println(countPrimes(1500000));
    }
}
