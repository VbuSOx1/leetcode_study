package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author weib
 * @date 2022-04-16 11:36
 */
public class M5 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n-1];
        for (int i = 0; i < p.length; i++) {
            p[i] = sc.nextInt();
        }
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] u = new int[m];
        int[] v = new int[m];
        for (int i = 0; i < m; i++) {
            u[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            v[i] = sc.nextInt();
        }

        int[] result = new int[m];
        HashSet<Integer> set = new HashSet<>();
        for (int i =0; i < m; i++) {
            int u1 = u[i];
            while (u1 != 1) {
                set.add(c[u1-1]);
                u1 = p[u1-2];
            }
            int v1 = v[i];
            while (v1 != 1) {
                set.add(c[v1-1]);
                v1 = p[v1-2];
            }
            set.add(c[0]);
            Iterator<Integer> iterator = set.iterator();
            int rr = 0;
            for (Integer r : set) {
                rr = rr^r;
            }
            result[i] = rr;
        }
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
}
