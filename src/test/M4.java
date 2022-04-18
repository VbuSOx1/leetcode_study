package test;

import java.util.Scanner;

/**
 * @author weib
 * @date 2022-04-16 10:45
 */
public class M4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();

        if (low > high) {
            int t = low;
            low = high;
            high = t;
        }
        System.out.println(bfs(low, high)); ;
//        int count = 0;
//        while (low == high) {
//            int l = low;
//            int h = high;
//            int c = 0;
//            if (h / l == 1) {
//                count += Math.min(h-l, Math.abs(l*2-h)+1);
//                break;
//            }
//            if (h / l == 2) {
//                count += Math.min(h/2 - l + 1, h - l*2 + 1);
//                break;
//            }
//            if (h / l > 2) {
//
//            }

    }

    public static int bfs (int low, int high) {
        if (high / low > 2) {
            return Math.min(bfs(low*2, high), bfs(low, high/2)) + 1;
        }
        if (high / low == 2) {
            return Math.min(high/2 - low + 1, high - low*2 + 1);
        }
        if (high / low == 1) {
            return Math.min(high-low, Math.abs(low*2-high)+1);
        }
        return 0;
    }



}
