package test;

import java.util.Scanner;

/**
 * @author weib
 * @date 2022-04-16 10:25
 */
public class M3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ls = new int[m];
        int[] rs = new int[m];
        for (int i = 0; i < m; i++) {
            ls[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            rs[i] = sc.nextInt();
        }
        int[] ns = new int[n+1];
        for (int i = 0; i < m; i++) {
            for (int j = ls[i]; j <= rs[i]; j++) {
                ns[j] = ++ns[j];
            }
        }
        int count = 0;
        for (int nn : ns) {
            if (nn >= 2) {
                count++;
            }
        }
        System.out.println(count);

    }
}
