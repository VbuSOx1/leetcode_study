package test;

import java.util.Scanner;

/**
 * @author weib
 * @date 2022-04-16 15:06
 */
public class W2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        // -1 情况
        int sum =0;
        for (int i = k-n+1; i <= k; i++) {
            sum += i;
        }
        if (sum < x) {
            System.out.println(-1);
            return;
        }

        int[] result = new int[n];
        if (set(result, 0, 1, k, n ,0, x)) {
            for (int i : result) {
                System.out.print(i + " ");
            }
        }else {
            System.out.println("-1");

        }
    }

    public static boolean set(int[] result, int curIndex, int startV,int k, int n, int sum, int x) {
        if (curIndex == n) {
            if (sum == x) {
                return true;
            }else {
                return false;
            }
        }
        for (int i = startV; i <= k; i++) {
            result[curIndex] = i;
            sum += i;
            if(set(result, curIndex+1, i+1, k, n, sum, x)) {
                return true;
            }
            sum -= i;
        }
        return false;
    }

}
