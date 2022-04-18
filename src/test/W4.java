package test;

import java.util.Scanner;

/**
 * @author weib
 * @date 2022-04-16 15:42
 */
public class W4 {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long mul = 1;
                for (int k = i; k <=j; k++){
                    mul *= p[k];
                }
                while (mul > 0) {
                    if (mul / 10 > 0) {
                        count++;
                        mul /= 10;
                    }else {
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
